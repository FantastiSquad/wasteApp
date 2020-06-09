package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.City;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickupPointRepository  extends JpaRepository<PickupPoint, Long> {

    // Recherche par nom exact
    @Query(value = "select * from pickup_points where locality = :locality", nativeQuery = true)
    List<PickupPoint> getByLocality(String locality);

    // Recherche d'une liste de pickup points par un pattern de localité
    @Query(value = "select * from pickup_points where locality like %:locality%", nativeQuery = true)
    List<PickupPoint> findByLocality(String locality);

    // Recherche dans une zone carré autour d'une position Géolocalisée (LATpt, LONGpt)
    // Latitude : 1°=+-111 km
    // Longitude, depends on latitude :
    //    - Nice 1°=+-82 km
    //    - Lille 1°=+-71 km
    // --> Average Longitude for france : 76 km to simplify process
    // Then a square of 2d side centered on a position :
    //    LATpt - d/111 < LAT < LATpt + d/111
    //    LONGpt - d/76 < LONG < LONGpt + d/76
    @Query(value = "select * from pickup_points where (cast(latitude as decimal(10,8)) between :lat-:side/111 and :lat+:side/111) and (cast(longitude as decimal(10,8)) between :lon-:side/76 and :lon+:side/76)", nativeQuery = true)
    List<PickupPoint> findBySquaredGeolocation(String lat, String lon, String side);
}
