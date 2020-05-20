package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Location;
import com.fantastiSquad.wasteApp.models.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "LocationServiceImpl")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Optional<List<Location>> getAllLocations() {
        return Optional.empty();
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Location> saveOrUpdateLocation(Location location) {
        return Optional.empty();
    }

    @Override
    public Optional<Location> saveLocationById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteLocation(Long id) {

    }
}
