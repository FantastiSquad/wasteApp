package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.GeoLocation;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import com.fantastiSquad.wasteApp.models.repositories.PackagingRepository;
import com.fantastiSquad.wasteApp.models.repositories.PickupPointRepository;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Service(value = "PickupPointServiceImpl")
public class PickupPointServiceImpl implements PickupPointService {

    @Autowired
    private PickupPointRepository pickupPointRepository;
    @Autowired
    private PackagingRepository packagingRepository;

    @Override
    public Optional<List<PickupPoint>> getAllPickupPoints() {
        return Optional.of(pickupPointRepository.findAll());
    }

    @Override
    public Optional<PickupPoint> getPickupPointById(Long id) {
        return pickupPointRepository.findById(id);
    }

    @Override
    public Optional<List<PickupPoint>> getPickupPointByGeoLocation(GeoLocation geolocation) {
        return Optional.empty();
    }

    @Override
    public Optional<List<PickupPoint>> findBySquaredGeolocation(String latitude, String longitude, String side) {
        System.out.println("PickupPointServiceImpl.findPickupPointByLocality(latitude: "+latitude+", longitude: "+longitude+", side: "+side+")");
        if (Double.valueOf(side) < 0) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "distance de recherche négative ! " + side);
        }
        List<PickupPoint> pickupPoints = pickupPointRepository.findBySquaredGeolocation(latitude, longitude, side);

        // FYI : https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf624858a603515f754806bc51c989d6a2d330&start=7.2017595,43.70400028&end=7.208046,43.687414
        RestAssured.baseURI = "https://api.openrouteservice.org";
        Map<String, Object> parametersMap = new HashMap<>();
        parametersMap.put("api_key", "5b3ce3597851110001cf624858a603515f754806bc51c989d6a2d330");
        parametersMap.put("start", longitude +","+ latitude );
        // if (!pickupPoints.isEmpty()) {}
        pickupPoints.forEach( point -> {
            System.out.println("id: "+point.getId()+", locality: "+point.getLocation().getLocality()+", type: "+point.getDestination()+", geolocation: "+point.getLocation().getGeolocation().geoLocationToString());

            parametersMap.put("end", point.getLocation().getGeolocation().geoLocationToString());
            // Response response = given().log().all().params(parametersMap).when().get("v2/directions/driving-car").thenReturn();
            Response response = given().params(parametersMap).when().get("v2/directions/driving-car").thenReturn(); // System.out.println(response.getBody().asString());
            JsonPath jsonPath = response.getBody().jsonPath();
            point.getLocation().getGeolocation().setRoadDistance(jsonPath.getString("features[0].properties.summary.distance"));
            point.getLocation().getGeolocation().setRoadDuration(jsonPath.getString("features[0].properties.summary.duration"));
            System.out.println("openrouteservice.org -> road Vectors: "+point.getLocation().getGeolocation().estimatedRoadVectorToString());
        });
        // A - check GET status before proceeding
        // B - add sort 1/ duration 2/ distance
        // C - check multi destination request (answer time gain)
        return Optional.of(pickupPoints);
    }

    @Override
    public Optional<List<PickupPoint>> getPickupPointByLocality(String locality) {
        return Optional.of(pickupPointRepository.getByLocality(locality));
    }

    @Override
    public Optional<List<PickupPoint>> findPickupPointByLocality(String locality) {
        return Optional.of(pickupPointRepository.findByLocality(locality));
    }

    @Override
    public Optional<PickupPoint> saveOrUpdatePickupPoint(PickupPoint pickupPoint) {
        return Optional.of(pickupPointRepository.save(pickupPoint));
    }

//    @Override
//    public Optional<PickupPoint> updatePickupPointById(Long id) {
//        PickupPoint pickupPoint = pickupPointRepository.findById(id).map(item -> {
//            return item;
//        }).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun point de collecte trouvé avec l'id : " + id));
//        return Optional.of(pickupPointRepository.save(pickupPoint));
//    }

    @Override
    public boolean deletePickupPoint(Long id) {
        pickupPointRepository.findById(id).map(item -> {
            pickupPointRepository.deleteById(id);
            return item;
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun point de collecte trouvé avec l'id : " + id));
        return true;
    }
}
