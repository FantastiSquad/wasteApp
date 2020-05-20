package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "PickPointServiceImpl")
public class PickPointServiceImpl implements PickupPointService {

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
