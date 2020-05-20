package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    Optional<List<Location>> getAllLocations();

    Optional<Location> getLocationById(Long id);

    Optional<Location> saveOrUpdateLocation(Location location);

    Optional<Location> saveLocationById(Long id);

    void deleteLocation(Long id);

}
