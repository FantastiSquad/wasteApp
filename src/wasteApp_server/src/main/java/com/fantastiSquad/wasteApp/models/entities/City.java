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

  private String name;
  private String citycode;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @Fetch(FetchMode.SELECT)
  private Set<BinTarget> binTarget = new HashSet<>();

  public City(Long id, String name, String citycode,
      Set<BinTarget> binTarget) {
    this.id = id;
    this.name = name;
    this.citycode = citycode;
    this.binTarget = binTarget;
  }

  public City(String name, String citycode,
      Set<BinTarget> binTarget) {
    this.name = name;
    this.citycode = citycode;
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

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getcitycode() {
    return citycode;
  }

  public void setcitycode(String citycode) {
    this.citycode = citycode;
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
        ", name='" + name + '\'' +
        ", citycode='" + citycode + '\'' +
        ", binTarget=" + binTarget +
        '}';
  }
}
