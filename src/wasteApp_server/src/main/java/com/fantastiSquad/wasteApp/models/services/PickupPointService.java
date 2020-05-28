package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.GeoLocation;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;

import java.util.List;
import java.util.Optional;

public interface PickupPointService {

    Optional<List<PickupPoint>> getAllPickupPoints();

    Optional<PickupPoint> getPickupPointById(Long id);

    Optional<List<PickupPoint>> getPickupPointByGeoLocation(GeoLocation gealocation);

    Optional<List<PickupPoint>> getPickupPointByLocality(String locality);

    Optional<PickupPoint> saveOrUpdatePickupPoint(PickupPoint pickupPoint);

//    Optional<PickupPoint> updatePickupPointById(Long id);

    boolean deletePickupPoint(Long id);

//    Optional<User> getUserById(Long id);
//    Optional<JobOffer> getJobOfferById(Long id);
//    Optional<List<PickupPoint>> getJobApplicationsByUserId(Long userId);
//    Optional<List<PickupPoint>> getJobApplicationsByJobOfferId(Long jobOfferId);
//    Optional<User> setUserById(Long id, Long userId);
//    Optional<JobOffer> setJobOfferById(Long id, Long jobOfferId);

}
