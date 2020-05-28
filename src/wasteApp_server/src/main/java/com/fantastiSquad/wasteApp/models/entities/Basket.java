package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "basket")
public class Basket {

    //	--------------------------------------- Class attributes --------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();

    //	------------------------------------------ Constructors ---------------------------------------------------------------------------
    public Basket() {
        super();
    }

    public Basket(Long userId) {
        this.userId = userId;
    }

    //	--------------------------------------- Getters & Setters -------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    //	--------------------------------------- Methods --------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", userId=" + userId +
                ", products=" + products +
                '}';
    }
}
