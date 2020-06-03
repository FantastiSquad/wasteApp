package com.fantastiSquad.wasteApp.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="groupment")
public class Groupment {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	@Fetch(FetchMode.SELECT)
	private Set<City> city = new HashSet<>();
	
	

	public Groupment() {
		super();
	}
	
	public Groupment(String name, Set<City> city) {
		super();
		this.name = name;
		this.city = city;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Groupement [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
