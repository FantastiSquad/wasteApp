package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pickup_point")
public class PickupPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne()
//    private Location location;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"pickupPointSet"})
    private Set<Packaging> packagingSet = new HashSet<Packaging>();

    public PickupPoint(Long id, /*Location location, */Set<Packaging> packagingSet) {
        this.id = id;
//        this.location = location;
        this.packagingSet = packagingSet;
    }

    public PickupPoint(/*Location location, */Set<Packaging> packagingSet) {
//        this.location = location;
        this.packagingSet = packagingSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Location getLocation() {
//        return this.location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public Set<Packaging> getPackagingSet() {
        return this.packagingSet;
    }

    public void setPackagingSet(Set<Packaging> packagingSet) {
        this.packagingSet = packagingSet;
    }

    @Override
    public String toString() {
        return "PickupPoint[id=" + this.id +
//                ", location=" + this.location +
                ", packagingSet=" + this.packagingSet +
                "]";
    }
}