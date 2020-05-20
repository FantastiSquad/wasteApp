package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long latitude;
    private Long longitude;
    private String address01;
    private String address02;
    private String postalCode;
    private String city;

    @OneToOne
    @MapsId
    private PickupPoint pickupPoint;

    public Location(){}

    public Location(Long id, Long latitude, Long longitude, String address01, String address02, String postalCode, String city, PickupPoint pickupPoint) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address01 = address01;
        this.address02 = address02;
        this.postalCode = postalCode;
        this.city = city;
        this.pickupPoint = pickupPoint;
    }

    public Location(Long latitude, Long longitude, String address01, String address02, String postalCode, String city, PickupPoint pickupPoint) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address01 = address01;
        this.address02 = address02;
        this.postalCode = postalCode;
        this.city = city;
        this.pickupPoint = pickupPoint;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getAddress01() {
        return this.address01;
    }

    public void setAddress01(String adress01) {
        this.address01 = adress01;
    }

    public String getAddress02() {
        return this.address02;
    }

    public void setAddress02(String adress02) {
        this.address02 = adress02;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public PickupPoint getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(PickupPoint pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    @Override
    public String toString() {
        return "Location[" +
                "id=" + this.id +
                ", latitude=" + this.latitude +
                ", longitude=" + this.longitude +
                ", adress01='" + this.address01 + '\'' +
                ", adress02='" + this.address02 + '\'' +
                ", postalCode='" + this.postalCode + '\'' +
                ", city=" + this.city +
                ']';
    }
}
