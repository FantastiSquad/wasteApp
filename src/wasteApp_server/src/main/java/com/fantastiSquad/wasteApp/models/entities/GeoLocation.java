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

    // to provide road distance and duration when Geolocalized
    @Transient
    private String roadDistance;
    @Transient
    private String roadDuration;


//    @OneToOne
//    @MapsId
//    private Location location;

    public GeoLocation() {
        this.latitude = "";
        this.longitude = "";
    }

    public GeoLocation(@NotNull(message = "Latitude cannot be null") String latitude, @NotNull(message = "Longitude cannot be null") String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoLocation(@NotNull(message = "Latitude cannot be null") String latitude, @NotNull(message = "Longitude cannot be null") String longitude, String roadDistance, String roadDuration) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.roadDistance = roadDistance;
        this.roadDuration = roadDuration;
    }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public String getRoadDistance() { return roadDistance; }
    public void setRoadDistance(String roadDistance) { this.roadDistance = roadDistance; }

    public String getRoadDuration() { return roadDuration; }
    public void setRoadDuration(String roadDuration) { this.roadDuration = roadDuration; }

    @Override
    public String toString() {
        return "[" + latitude
                + ", " + longitude
                + ", " + roadDistance
                + ", " + roadDuration
                + "]";
    }
    public String geoLocationToString() { return longitude + "," + latitude; }
    public String estimatedRoadVectorToString() { return roadDistance + "," + roadDuration; }

}
