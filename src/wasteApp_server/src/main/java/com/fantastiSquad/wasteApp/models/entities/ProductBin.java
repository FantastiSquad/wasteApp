package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "product_bin")
public class ProductBin {

    //	--------------------------------------- Class attributes --------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set <Product> products = new HashSet<Product>();

    //	------------------------------------------ Constructors ---------------------------------------------------------------------------
    public ProductBin() {
        super();
    }

    public ProductBin(Long userId) {
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
        return "ProductBin{" +
                "id=" + id +
                ", userId=" + userId +
                ", products=" + products +
                '}';
    }
}
