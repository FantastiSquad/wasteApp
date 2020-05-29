package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name="geolocations")
@Embeddable
public class GeoLocation {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @NotNull(message = "Latitude cannot be null")
    private String latitude;
    @NotNull(message = "Longitude cannot be null")
    private String longitude;

//    @OneToOne
//    @MapsId
//    private Location location;

    public GeoLocation() {
        this.latitude = "";
        this.longitude = "";
    }

    public GeoLocation(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "[" + latitude + "/" + longitude + "]";
    }
}
