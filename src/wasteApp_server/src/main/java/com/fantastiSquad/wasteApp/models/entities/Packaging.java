package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Packaging")
public class Packaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Packaging_id")
    @JsonIgnoreProperties({"PackagingSet"})
    private Set<Packaging> PickupPointSet = new HashSet<>();

}
