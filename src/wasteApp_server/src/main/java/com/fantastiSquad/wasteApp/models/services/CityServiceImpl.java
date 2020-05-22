package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.City;
import com.fantastiSquad.wasteApp.models.repositories.CityRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="cityService")
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository cityRepository;

  @Override
  public List<City> getAllCities() {
    return cityRepository.findAll();
  }

  @Override
  public Optional<List<City>> searchCityByName(String name) {
    return cityRepository.findByName(name);
  }

  @Override
  public Optional<City> getCityById(Long id) {
    return cityRepository.findById(id);
  }

  @Override
  public City saveOrUpdateCity(City city) {
    return cityRepository.save(city);
  }

  @Override
  public void deleteCity(Long id) {
      cityRepository.deleteById(id);
  }
}
