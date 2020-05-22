package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bintarget")
public class BinTarget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String category;
	private String material;
	private Destination destination;
	private String color;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "city_id")
	private City city;

	public BinTarget(Long id, String category, String material, Destination destination, String color, City city) {
		super();
		this.id = id;
		this.category = category;
		this.material = material;
		this.destination = destination;
		this.color = color;
		this.city = city;
	}
	
	

	public BinTarget(String category, String material, Destination destination, String color, City city) {
		super();
		this.category = category;
		this.material = material;
		this.destination = destination;
		this.color = color;
		this.city = city;
	}



	public BinTarget() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "BinTarget{" + "id=" + id + ", category='" + category + '\'' + ", material='" + material + '\''
				+ ", destination=" + ", color='" + color + '\'' + ", city=" + city + '}';
	}
}
