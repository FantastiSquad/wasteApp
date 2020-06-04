package com.fantastiSquad.wasteApp.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="brands")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "name","notation"})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String notation;
    @OneToMany(mappedBy = "industry", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    Set<Product> products = new HashSet<Product>();

}
