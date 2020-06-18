package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_bin")
public class ProductBin {

    //	--------------------------------------- Class attributes --------------------------------------------------------------------------
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JsonIgnore
    private User user;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> productsBin = new HashSet<Product>();

    //	------------------------------------------ Constructors ---------------------------------------------------------------------------
    public ProductBin() {}

    public ProductBin(User user) {
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

    public void setUserId(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return productsBin;
    }

    public void setProducts(Set<Product> products) {
        this.productsBin = products;
    }
    //	--------------------------------------- Methods --------------------------------------------------------------------------
    @Override
    public String toString() {
        return "ProductBin{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + productsBin +
                '}';
    }
}
