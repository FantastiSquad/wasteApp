package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;

@Entity
@Table(name="Cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
