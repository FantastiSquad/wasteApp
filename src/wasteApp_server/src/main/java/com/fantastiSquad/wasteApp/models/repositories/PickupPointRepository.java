package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupPointRepository  extends JpaRepository<PickupPoint, Long> {

}
