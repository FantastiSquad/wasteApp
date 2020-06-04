package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findByName(String name);
    Optional<Product> findByBarcode(String barCode);
    Optional<Product> getProductById(Long id);
    Optional<List<Product>> getProducts();
    Optional<Product> saveOrUpdateProduct(Product product);
    boolean deleteProduct(Long id);
}
