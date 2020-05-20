package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
