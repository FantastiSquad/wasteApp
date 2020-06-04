package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Product;
import com.fantastiSquad.wasteApp.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service(value="productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    private static final String REQUEST_POST = "post";
    private static final String REQUEST_PUT = "put";

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findByBarcode(String barCode) {
        return productRepository.findByBarcode(barCode);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> getProducts() {
        return  Optional.of(productRepository.findAll());
    }

    @Override
    public Optional<Product> saveOrUpdateProduct(Product product) {
        return Optional.of(productRepository.save(product));
        }

    @Override
    public boolean deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"id product not found " + id));
        productRepository.deleteById(id);
        return true;
    }

}