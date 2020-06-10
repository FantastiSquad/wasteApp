package com.fantastiSquad.wasteApp.models.services;

import java.util.List;
import java.util.Optional;

import com.fantastiSquad.wasteApp.models.entities.Groupment;

public interface GroupmentService  {

	Optional<List<Groupment>> getAllGroupments();
	Optional<Groupment> getGroupmentByName(String name);
	Optional<Groupment> saveOrUpdateGroupment(Groupment groupment);
}
