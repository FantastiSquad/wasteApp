package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.City;
import com.fantastiSquad.wasteApp.models.repositories.CityRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service(value="cityService")
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository cityRepository;

  @Override
  public Optional<List<City>> getAllCities() {
    return Optional.of(cityRepository.findAll());
  }

  @Override
  public List<City> searchCityByName(String name) {
    return cityRepository.findByName(name);
  }

  @Override
  public Optional<City> getCityById(Long id) {
    return cityRepository.findById(id);
  }

  @Override
  public Optional<City> saveOrUpdateCity(City city) {
    return Optional.of(cityRepository.save(city));
  }

  @Override
  public boolean deleteCity(Long id) {
      cityRepository.findById(id).map(item -> {
    	  cityRepository.deleteById(id);
    	  return true;    
      }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aucune ville trouvée avec l'id: " + id));
      	return false;
  }
}
