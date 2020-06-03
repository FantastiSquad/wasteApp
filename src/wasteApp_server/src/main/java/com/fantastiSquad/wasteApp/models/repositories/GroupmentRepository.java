package com.fantastiSquad.wasteApp.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fantastiSquad.wasteApp.models.entities.Groupment;

public interface GroupmentRepository extends JpaRepository<Groupment, Integer>{
	
	//Recherche d'un groupement par son nom ou une partie de son nom
    @Query(value = "select * from groupment where name like %:name%", nativeQuery = true)
    Groupment findByGroupName(String name);
}
