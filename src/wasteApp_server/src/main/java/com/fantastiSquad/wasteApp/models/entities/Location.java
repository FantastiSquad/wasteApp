package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name="locations")
@Embeddable
public class Location {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @OneToOne(mappedBy = "geolocation", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"location"})
    @NotNull(message = "GeoLocation cannot be null")
    private GeoLocation geolocation;
    private String subThoroughfare; // street number
    @NotNull(message = "Street name cannot be null")
    private String thoroughfare; // street name
    @NotNull(message = "postal Code cannot be null")
    private String postalCode;
    @NotNull(message = "City/Localilty cannot be null")
    private String locality; // City

//    @OneToOne
//    @MapsId
//    private PickupPoint pickupPoint;

    public Location(){}

    public Location(String latitude, String longitude, String subThoroughfare, String thoroughfare, String postalCode, String locality) {
        this.geolocation = new GeoLocation(latitude, longitude);
        this.subThoroughfare = subThoroughfare;
        this.thoroughfare = thoroughfare;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public GeoLocation getGeolocation() { return this.geolocation; }

    public void setGeolocation(GeoLocation geolocation) { this.geolocation = geolocation; }

    public String getSubThoroughfare() {
        return this.subThoroughfare;
    }

    public void setSubThoroughfare(String subThoroughfare) {
        this.subThoroughfare = subThoroughfare;
    }

    public String getThoroughfare() {
        return this.thoroughfare;
    }

    public void setThoroughfare(String thoroughfare) {
        this.thoroughfare = thoroughfare;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Location[" +
//                "id=" + this.id +
                ", geolocation=" + this.geolocation +
                ", subThoroughfare='" + this.subThoroughfare + '\'' +
                ", thoroughfare='" + this.thoroughfare + '\'' +
                ", postalCode='" + this.postalCode + '\'' +
                ", locality=" + this.locality +
                ']';
    }
}
