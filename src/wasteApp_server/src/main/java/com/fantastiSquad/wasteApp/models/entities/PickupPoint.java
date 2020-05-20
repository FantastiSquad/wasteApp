package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PickupPoint")
public class PickupPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Location location;

    @OneToMany(mappedBy = "PickupPoint", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"PickupPointSet"})
    private Set<Packaging> packagingSet = new HashSet<>();

    public PickupPoint(Long id, Location location, Set<Packaging> packagingSet) {
        this.id = id;
        this.location = location;
        this.packagingSet = packagingSet;
    }

    public PickupPoint(Location location, Set<Packaging> packagingSet) {
        this.location = location;
        this.packagingSet = packagingSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Packaging> getPackagingSet() {
        return packagingSet;
    }

    public void setPackagingSet(Set<Packaging> packagingSet) {
        this.packagingSet = packagingSet;
    }

    @Override
    public String toString() {
        return "PickupPoint[id=" + id +
                ", location=" + location +
                ", packagingSet=" + packagingSet +
                "]";
    }
}