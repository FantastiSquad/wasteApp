package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.GeoLocation;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface PickupPointService {

    Optional<List<PickupPoint>> getAllPickupPoints();

    Optional<PickupPoint> getPickupPointById(Long id);

    Optional<List<PickupPoint>> getPickupPointByGeoLocation(GeoLocation geolocation);
    Optional<List<PickupPoint>> findBySquaredGeolocation(String latitude, String longitude, String side);

    Optional<List<PickupPoint>> getPickupPointByLocality(String locality);
    Optional<List<PickupPoint>> findPickupPointByLocality(String locality);

    Optional<PickupPoint> saveOrUpdatePickupPoint(PickupPoint pickupPoint);

//    Optional<PickupPoint> updatePickupPointById(Long id);

    boolean deletePickupPoint(Long id);
}
