package com.fantastiSquad.wasteApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fantastiSquad.wasteApp.models.entities.Groupment;
import com.fantastiSquad.wasteApp.models.services.GroupmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/groupment")
public class GroupmentController {
	
	@Autowired
	GroupmentService groupmentService;
	
	@GetMapping(value="")
	public ResponseEntity<List<Groupment>> getAllGroupments(){
		List<Groupment> groupmentsFromDb = groupmentService.getAllGroupments()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun groupement trouvé!"));
		
		return new ResponseEntity<List<Groupment>>(groupmentsFromDb, HttpStatus.OK);
	}
	//Permet de récupérer un groupement par son nom ou une partie de son nom
	
	@GetMapping(value="/search/{name}")
	public ResponseEntity<Groupment> getGroupmentByName(@PathVariable("name") String name){
		Groupment groupmentFromDb = groupmentService.getGroupmentByName(name)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun groupement avec le nom: " + name));
		return new ResponseEntity<Groupment>(groupmentFromDb, HttpStatus.OK);
		
	}
	
//	@PostMapping(value="")
//	public ResponseEntity<Groupment> saveOrUpdateGroupment(@Valid @RequestBody Groupment groupment){
//		Groupment newGroupment = groupmentService.saveOrUpdateGroupment(groupment)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "impossible d'enregistrer le groupement!"));
//		return new ResponseEntity<Groupment>( newGroupment,HttpStatus.OK);
//	}

	
		

}
