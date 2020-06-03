package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pickup_points")
public class PickupPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "pickupPoint", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"pickupPoint"})
    @Valid
    private Location location;

    @Enumerated(EnumType.ORDINAL)
    private Destination destination;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"pickupPointSet"})
    private Set<Packaging> packagingSet = new HashSet<Packaging>();

    public PickupPoint() {}

    public PickupPoint(Long id, Location location, Destination destination, Set<Packaging> packagingSet) {
        this.id = id;
        this.location = location;
        this.destination = destination;
        this.packagingSet = packagingSet;
    }

    public PickupPoint(Location location, Destination destination, Set<Packaging> packagingSet) {
        this.location = location;
        this.destination = destination;
        this.packagingSet = packagingSet;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public Location getLocation() { return this.location; }
    public void setLocation(Location location) { this.location = location; }

    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }

    public Set<Packaging> getPackagingSet() { return this.packagingSet; }
    public void setPackagingSet(Set<Packaging> packagingSet) { this.packagingSet = packagingSet; }

    @Override
    public String toString() {
        return "PickupPoint[id=" + this.id +
                ", location=" + this.location +
                ", destination=" + this.destination +
                ", packagingSet=" + this.packagingSet +
                "]";
    }
}