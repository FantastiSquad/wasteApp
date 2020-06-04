package com.fantastiSquad.wasteApp.controllers;

import com.fantastiSquad.wasteApp.models.entities.GeoLocation;
import com.fantastiSquad.wasteApp.models.entities.PickupPoint;
import com.fantastiSquad.wasteApp.models.services.PickupPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pickups")
public class PickupPointController {

    @Autowired
    private PickupPointService pickupPointService;

    // #########################################################################
    // Get methods
    // #########################################################################

    // Provide all pickup points
    @GetMapping(value = "")
    public ResponseEntity<List<PickupPoint>> getAllPickupPoints() {
        List<PickupPoint> pickupPoints = pickupPointService.getAllPickupPoints()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun point de collecte trouvé."));
        return new ResponseEntity<List<PickupPoint>>(pickupPoints, HttpStatus.OK);
    }

    // Provide pickup point by its id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PickupPoint> getPickupPointById(@PathVariable(value = "id") Long id) {
        PickupPoint pickupPoint = pickupPointService.getPickupPointById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun point de collecte trouvé avec l'id : " + id));
        return new ResponseEntity<PickupPoint>(pickupPoint, HttpStatus.OK);
    }

    // Provide list of pickup point by geoloation
    @GetMapping(value = "/geolocation")
    public ResponseEntity<List<PickupPoint>> getPickupPointByGeoLocation(
            @RequestParam(name = "lat", required = true) String latitude,
            @RequestParam(name = "lon", required = true) String longitude) {
        GeoLocation geolocation = new GeoLocation(latitude, longitude);
        List<PickupPoint> pickupPoints = pickupPointService.getPickupPointByGeoLocation(geolocation)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "fonction non implémentée pour le moment - provided geolocation : " + geolocation));
        return new ResponseEntity<List<PickupPoint>>(pickupPoints, HttpStatus.OK);
    }

    // Provide list of pickup point by geoloation
    @GetMapping(value = "/locality/{locality}")
    public ResponseEntity<List<PickupPoint>> getPickupPointByLocality(@PathVariable(value = "locality") String locality) {
        List<PickupPoint> pickupPoints = pickupPointService.getPickupPointByLocality(locality)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun point de collecte trouvé avec la localité : " + locality));
        return new ResponseEntity<List<PickupPoint>>(pickupPoints, HttpStatus.OK);
    }


    // #########################################################################
    // Post methods
    // #########################################################################

    // Create a new pickup point
    @PostMapping(value = "")
    public ResponseEntity<PickupPoint> savePickupPoint(@Valid @RequestBody PickupPoint pickupPoint) {
        PickupPoint pickupPointSaved = pickupPointService.saveOrUpdatePickupPoint(pickupPoint)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de sauver le point de collecte fourni."));
        return new ResponseEntity<PickupPoint>(pickupPoint, HttpStatus.OK);
    }

    // #########################################################################
    // Put methods
    // #########################################################################

    // Update an pickup point
    @PutMapping(value = "")
    public ResponseEntity<PickupPoint> updatePickupPoint(@Valid @RequestBody PickupPoint pickupPoint) {
        PickupPoint pickupPointSaved = pickupPointService.saveOrUpdatePickupPoint(pickupPoint)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de sauver le point de collecte fourni."));
        return new ResponseEntity<PickupPoint>(pickupPoint, HttpStatus.OK);
    }

    // #########################################################################
    // Delete methods
    // #########################################################################

    // Delete pickup point by its id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deletePickupPoint(@PathVariable(value = "id") Long id) {
        if ( pickupPointService.deletePickupPoint(id) ) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>( false, HttpStatus.NOT_FOUND);
        }


    }

}
