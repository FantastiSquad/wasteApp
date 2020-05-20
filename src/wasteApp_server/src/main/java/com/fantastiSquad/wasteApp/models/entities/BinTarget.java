package com.fantastiSquad.wasteApp.models.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="binTarget")
public class BinTarget {

  private Long id;
  private String category;
  private String material;
  private Set<String> destination = new HashSet<String>();
  private String color;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name="city_id")
  private City city;

  public BinTarget(Long id, String category, String material,
      Set<String> destination, String color, City city) {
    this.id = id;
    this.category = category;
    this.material = material;
    this.destination = destination;
    this.color = color;
    this.city = city;
  }

  public BinTarget(String category, String material, Set<String> destination, String color,
      City city) {
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

  public Set<String> getDestination() {
    return destination;
  }

  public void setDestination(Set<String> destination) {
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
    return "BinTarget{" +
        "id=" + id +
        ", category='" + category + '\'' +
        ", material='" + material + '\'' +
        ", destination=" + destination +
        ", color='" + color + '\'' +
        ", city=" + city +
        '}';
  }
}
