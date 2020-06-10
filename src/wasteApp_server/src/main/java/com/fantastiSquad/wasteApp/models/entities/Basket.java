package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "basket")
public class Basket {

    //	--------------------------------------- Class attributes --------------------------------------------------------------------------
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JsonIgnore
    private User user;
    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Product> productsBasket = new HashSet<Product>();

    //	------------------------------------------ Constructors ---------------------------------------------------------------------------
    public Basket() {}

    public Basket(User user) {
        this.user = user;
    }

    //	--------------------------------------- Getters & Setters -------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return productsBasket;
    }

    public void setProducts(Set<Product> products) {
        this.productsBasket = products;
    }

    //	--------------------------------------- Methods --------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + productsBasket +
                '}';
    }
}
