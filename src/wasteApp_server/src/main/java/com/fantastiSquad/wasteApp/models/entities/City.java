package com.fantastiSquad.wasteApp.models.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String city_name;
  private String cityCode;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @Fetch(FetchMode.SELECT)
  private Set<BinTarget> binTarget = new HashSet<>();

  public City(Long id, String city_name, String cityCode,
      Set<BinTarget> binTarget) {
    this.id = id;
    this.city_name = city_name;
    this.cityCode = cityCode;
    this.binTarget = binTarget;
  }

  public City(String city_name, String cityCode,
      Set<BinTarget> binTarget) {
    this.city_name = city_name;
    this.cityCode = cityCode;
    this.binTarget = binTarget;
  }

  public City() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCity_name() {
    return city_name;
  }

  public void setCity_name(String city_name) {
    this.city_name = city_name;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public Set<BinTarget> getBinTarget() {
    return binTarget;
  }

  public void setBinTarget(Set<BinTarget> binTarget) {
    this.binTarget = binTarget;
  }

  @Override
  public String toString() {
    return "City{" +
        "id=" + id +
        ", city_name='" + city_name + '\'' +
        ", cityCode='" + cityCode + '\'' +
        ", binTarget=" + binTarget +
        '}';
  }
}
