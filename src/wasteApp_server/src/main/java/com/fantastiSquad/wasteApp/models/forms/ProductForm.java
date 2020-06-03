package com.fantastiSquad.wasteApp.models.forms;

import com.fantastiSquad.wasteApp.models.entities.Brand;
import com.fantastiSquad.wasteApp.models.entities.Packaging;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString(of={"barcode","name","imageUrl","industry","keywords","packaging","quantity","Language","newProduct"})
public class ProductForm {

    @NotNull
    String barcode;
    @NotNull
    String name;
    String imageUrl;
    Brand industry;
    String[] keywords;
    @Positive
    Integer quantity;
    @NotNull
    String Language;
    @NotNull
    Boolean newProduct;
    String category;
    Set<Packaging> packaging = new HashSet<>();
}
