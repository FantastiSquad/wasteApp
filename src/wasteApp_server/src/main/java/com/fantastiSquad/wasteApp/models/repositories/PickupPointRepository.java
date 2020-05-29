package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.City;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickupPointRepository  extends JpaRepository<PickupPoint, Long> {

    //Recherche d'une ville par son nom
    @Query(value = "select * from pickup_points where locality like %:locality%", nativeQuery = true)
    List<PickupPoint> findByLocality(String locality);
}
