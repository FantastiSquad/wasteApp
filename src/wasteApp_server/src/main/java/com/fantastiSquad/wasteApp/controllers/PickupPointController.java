package com.fantastiSquad.wasteApp.controllers;

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

    // #########################################################################
    // Post methods
    // Optional<PickupPoint> saveOrUpdatePickupPoint(PickupPoint pickupPoint)
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
    // public boolean deletePickupPoint(Long id) {
    // #########################################################################

    // Provide pickup point by its id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deletePickupPoint(@PathVariable(value = "id") Long id) {
        if ( pickupPointService.deletePickupPoint(id) ) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>( false, HttpStatus.NOT_FOUND);
        }


    }

}
