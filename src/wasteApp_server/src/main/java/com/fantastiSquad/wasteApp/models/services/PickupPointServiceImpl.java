package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.GeoLocation;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import com.fantastiSquad.wasteApp.models.repositories.PackagingRepository;
import com.fantastiSquad.wasteApp.models.repositories.PickupPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
