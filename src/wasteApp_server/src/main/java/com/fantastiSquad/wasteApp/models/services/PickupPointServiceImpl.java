package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import com.fantastiSquad.wasteApp.models.repositories.PickupPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "PickupPointServiceImpl")
public class PickupPointServiceImpl implements PickupPointService {

    @Autowired
    private PickupPointRepository pickupPointRepository;

    @Override
    public Optional<List<PickupPoint>> getAllPickupPoints() {
        return Optional.empty();
    }

    @Override
    public Optional<PickupPoint> getPickupPointById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PickupPoint> saveOrUpdatePickupPoint(PickupPoint pickupPoint) {
        return Optional.empty();
    }

    @Override
    public Optional<PickupPoint> savePickupPointById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deletePickupPoint(Long id) {

    }
}
