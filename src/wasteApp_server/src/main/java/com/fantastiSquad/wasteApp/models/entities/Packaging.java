package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="packaging")
public class Packaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "packagingSet")
    @JsonIgnoreProperties({"packagingSet"})
    private Set<PickupPoint> pickupPointSet  = new HashSet<PickupPoint>();

    public Packaging(Long id, Set<PickupPoint> pickupPointSet) {
        this.id = id;
        this.pickupPointSet = pickupPointSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PickupPoint> getPickupPointSet() {
        return this.pickupPointSet;
    }

    public void setPickupPointSet(Set<PickupPoint> pickupPointSet) {
        this.pickupPointSet = pickupPointSet;
    }
}
