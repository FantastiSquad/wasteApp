package com.fantastiSquad.wasteApp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="products")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString(of={"id","barcode","name","imageUrl","industry","keywords","packaging","quantity","language","newProduct","category"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String barcode;
    @NotNull
    String name;
    String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable( name = "Product_Brand",
            joinColumns = @JoinColumn( name = "brand_id" ),
            inverseJoinColumns = @JoinColumn( name = "product_id" ) )
    @JsonIgnoreProperties("products")
    Brand industry;
    String[] keywords;
    @Positive
    Integer quantity;
    @NotNull
    String language;
    @NotNull
    Boolean newProduct;
    String category;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    Set<Packaging> packaging = new HashSet<Packaging>();


    public Product(Long id, @NotNull String barcode, @NotNull String name, String imageUrl, Brand industry, String[] keywords, @Positive Integer quantity, @NotNull String language, @NotNull Boolean newProduct, String category, Set<Packaging> packaging) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.imageUrl = imageUrl;
        this.industry = industry;
        this.keywords = keywords;
        this.quantity = quantity;
        this.language = language;
        this.newProduct = newProduct;
        this.category = Category.getDescription(category);;
        this.packaging = packaging;
    }
}
