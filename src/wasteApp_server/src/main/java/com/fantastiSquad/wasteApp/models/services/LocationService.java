package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Location;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    Optional<List<Location>> getAllLocations();

    Optional<Location> getLocationById(Long id);

    Optional<Location> saveOrUpdateLocation(Location location);

    Optional<Location> saveLocationById(Long id);

    void deleteLocation(Long id);

//    Optional<User> getUserById(Long id);
//    Optional<JobOffer> getJobOfferById(Long id);
//    Optional<List<PickupPoint>> getJobApplicationsByUserId(Long userId);
//    Optional<List<PickupPoint>> getJobApplicationsByJobOfferId(Long jobOfferId);
//    Optional<User> setUserById(Long id, Long userId);
//    Optional<JobOffer> setJobOfferById(Long id, Long jobOfferId);

}
