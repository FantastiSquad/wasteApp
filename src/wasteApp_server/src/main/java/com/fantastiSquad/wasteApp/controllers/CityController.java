package com.fantastiSquad.wasteApp.controllers;

import com.fantastiSquad.wasteApp.models.entities.City;

import com.fantastiSquad.wasteApp.models.services.CityService;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin("*")
@RestController
@RequestMapping("/city")
public class CityController {

  @Autowired
  CityService cityService;

  @GetMapping(value = "")
  public ResponseEntity<List<City>> getAllCities() {
    List<City> allCitiesFromDb =  cityService.getAllCities()
    		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune ville trouvée!"));
    return new ResponseEntity<List<City>>(allCitiesFromDb, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<City>> getCityById(@PathVariable("id") Long id) {
    Optional<City> cityFromDb = cityService.getCityById(id);
    if (cityFromDb.isPresent()) {
      return new ResponseEntity<Optional<City>>(cityFromDb, HttpStatus.OK);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "La ville avec l'id " + id + " n'a pas été trouvée!");
    }
  }

  @GetMapping(value="/searchCity/{name}")
  public ResponseEntity<List<City>> getCityByName(@PathVariable("name") String name){
      
      List<City> cityFromDb = cityService.searchCityByName(name);

      if(!cityFromDb.isEmpty()){
        return new ResponseEntity<List<City>>(cityFromDb, HttpStatus.OK);
      } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune ville trouvée avec ce nom");
      }
  }
  
  @PostMapping(value="")
  public ResponseEntity<City> createCity(@Valid @RequestBody City createCity){
	  //System.out.println(createCity);
	  City newCity = cityService.saveOrUpdateCity(createCity)
			  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossible d'enregister la ville dans la DB"));
	  return new ResponseEntity<City>(newCity, HttpStatus.OK);
  }

//  @PutMapping(value = "/update/{id}") Si ville à modifier , il faudra créer un formulaire
//  public ResponseEntity<City> updateCity(@PathVariable("id") Long id) {
//    Optional<City> citySearch = cityService.getCityById(id);
//
//    if (citySearch.isPresent()) {
//      City cityToUpdate = citySearch.get();
//      
//      cityToUpdate.setId(id);
//      cityToUpdate.setCity_name(cityToUpdate.getCity_name());
//      cityToUpdate.setCityCode(cityToUpdate.getCityCode());
//      
//      System.out.println(cityToUpdate);
//      City cityUpdated = cityService.saveOrUpdateCity(cityToUpdate);
//      return new ResponseEntity<City>(cityUpdated, HttpStatus.OK);
//
//    } else {
//      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aucune ville trouvée avec cet id");
//    }
//  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCity(@PathVariable("id") Long id){
      Optional<City> cityToDelete = cityService.getCityById(id);

      if(cityToDelete.isPresent()){
          cityService.deleteCity(id);
          return new ResponseEntity<String>(HttpStatus.OK);
      } else {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ville avec l'id " + id + " n'a pas été trouvée!");
      }
  }
}