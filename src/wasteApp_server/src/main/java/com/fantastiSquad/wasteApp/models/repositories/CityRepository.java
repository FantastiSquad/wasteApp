package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.City;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

  //Recherche d'une ville par son nom
    @Query(value = "select * from city where city_name like %:name%", nativeQuery = true)
    Optional<List<City>> findByName(String name);
}
