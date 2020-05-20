package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.City;
import java.util.List;
import java.util.Optional;

public interface CityService {
  /**
   * Retourne la liste des villes avec le code postal associé(ex: Nice: plusieurs codes postaux)
   *
   */
   List<City> getAllCities();

   Optional<City> getCityById(Long id);

   City saveOrUpdateCity(City city);

   void deleteCity(Long id);

}
