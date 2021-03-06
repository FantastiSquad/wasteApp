package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   Optional<List<Product>> findByNameContainsOrBarcodeContains(String name, String barcode);

   Optional<List<Product>>findByBarcodeContains(String barCode);
}
