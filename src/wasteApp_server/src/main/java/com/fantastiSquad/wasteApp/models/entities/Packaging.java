package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="packagings")
public class Packaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String notation;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "packagingSet")
//    @Column(name="pickup_point")
    @JsonIgnoreProperties({"packagingSet"})
    private Set<PickupPoint> pickupPointSet  = new HashSet<PickupPoint>();

    public Packaging(){}

    public Packaging(Long id, String name, String notation, Set<PickupPoint> pickupPointSet) {
        this.id = id;
        this.name = name;
        this.notation = notation;
        this.pickupPointSet = pickupPointSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public Set<PickupPoint> getPickupPointSet() {
        return this.pickupPointSet;
    }

    public void setPickupPointSet(Set<PickupPoint> pickupPointSet) {
        this.pickupPointSet = pickupPointSet;
    }
}