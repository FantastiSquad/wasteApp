package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;

@Entity
@Table(name="Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long latitude;
    private Long longitude;
    private String adress01;
    private String adress02;
    private String postalCode;

    @OneToOne()
    private City city;

    public Location(Long id, Long latitude, Long longitude, String adress01, String adress02, String postalCode, City city) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.adress01 = adress01;
        this.adress02 = adress02;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Location(Long latitude, Long longitude, String adress01, String adress02, String postalCode, City city) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.adress01 = adress01;
        this.adress02 = adress02;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getAdress01() {
        return adress01;
    }

    public void setAdress01(String adress01) {
        this.adress01 = adress01;
    }

    public String getAdress02() {
        return adress02;
    }

    public void setAdress02(String adress02) {
        this.adress02 = adress02;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location[" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", adress01='" + adress01 + '\'' +
                ", adress02='" + adress02 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city=" + city +
                ']';
    }
}
