package com.fantastiSquad.wasteApp.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantastiSquad.wasteApp.models.entities.Groupment;
import com.fantastiSquad.wasteApp.models.repositories.GroupmentRepository;

@Service(value="groupementService")
public class GroupmentServiceImpl implements GroupmentService{
	
	@Autowired
	private GroupmentRepository groupmentRepository;
	
	@Override
	public Optional<List<Groupment>> getAllGroupments(){
		return Optional.of(groupmentRepository.findAll());
		
	};
	
	@Override
	public Optional<Groupment> getGroupmentByName(String name){
		return Optional.of(groupmentRepository.findByGroupName(name));
		
	};
	
	@Override
	public Optional<Groupment> saveOrUpdateGroupment(Groupment groupment){
		return Optional.of(groupmentRepository.save(groupment));
		
	};
}
