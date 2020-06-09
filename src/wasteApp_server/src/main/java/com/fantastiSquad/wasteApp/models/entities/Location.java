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
    private String streetNumber; //  subThoroughfare
    @NotNull(message = "Street name cannot be null")
    private String streetName; // thoroughfare
    @NotNull(message = "postal Code cannot be null")
    private String postalCode;
    @NotNull(message = "City/Localilty cannot be null")
    private String locality; // City

//    @OneToOne
//    @MapsId
//    private PickupPoint pickupPoint;

    public Location(){}

    public Location(String latitude, String longitude, String streetNumber, String streetName, String postalCode, String locality) {
        this.geolocation = new GeoLocation(latitude, longitude);
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public GeoLocation getGeolocation() { return this.geolocation; }
    public void setGeolocation(GeoLocation geolocation) { this.geolocation = geolocation; }

    public String getStreetNumber() {
        return this.streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
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
                ", streetNumber='" + this.streetNumber + '\'' +
                ", streetName='" + this.streetName + '\'' +
                ", postalCode='" + this.postalCode + '\'' +
                ", locality=" + this.locality +
                ']';
    }
}
