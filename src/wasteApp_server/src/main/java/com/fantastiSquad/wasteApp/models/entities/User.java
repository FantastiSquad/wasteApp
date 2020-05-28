package com.fantastiSquad.wasteApp.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

    //	--------------------------------------- Class attributes --------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 20, message = "username must be between 2 and 20 characters")
    private String username;
    @Email(message = "email should be valid")
    private String email;
    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;
    private ProductBin productBin;
    private Basket basket;

    //	------------------------------------------ Constructors ---------------------------------------------------------------------------
    public User() {
        super();
        this.productBin = new ProductBin(this.id);
        this.basket = new Basket(this.id);
    }

    public User(@Size(min = 2, max = 20, message = "username must be between 2 and 20 characters") String username, @Email(message = "email should be valid") String email, @Size(min = 8, message = "password must be at least 8 characters") String password, ProductBin productBin, Basket basket) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.productBin = productBin;
        this.basket = basket;
    }

    //	--------------------------------------- Getters & Setters -------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProductBin getProductBin() {
        return productBin;
    }

    public void setProductBin(ProductBin productBin) {
        this.productBin = productBin;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    //	--------------------------------------- Methods --------------------------------------------------------------------------
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", productBin=" + productBin +
                ", basket=" + basket +
                '}';
    }
}
