package com.fantastiSquad.wasteApp.controllers;

import com.fantastiSquad.wasteApp.models.entities.Product;
import com.fantastiSquad.wasteApp.models.forms.ProductForm;

import com.fantastiSquad.wasteApp.models.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.Clock;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProduct(){
       List<Product> products = service.getProducts().orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "something wrong with findAll(getProducts) method, maybe take a look on your request"));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long id){
        Product product =service.getProductById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id product not found +" + id));
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product productSave = service.saveOrUpdateProduct(product).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "something wrong with save method, maybe take a look on your request"));
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

   @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable(value = "id") Long id, @RequestBody ProductForm product){
    Product productToUpdate =  service.getProductById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id product not found " + id));
    productToUpdate.setName(product.getName());
    productToUpdate.setBarcode(product.getBarcode());
    productToUpdate.setCategory(product.getCategory());
    productToUpdate.setImageUrl(product.getImageUrl());
    productToUpdate.setIndustry(product.getIndustry());
    productToUpdate.setKeywords(product.getKeywords());
    productToUpdate.setLanguage(product.getLanguage());
    productToUpdate.setNewProduct(product.getNewProduct());
    productToUpdate.setPackaging(product.getPackaging());
    productToUpdate.setQuantity(product.getQuantity());
    Product productUpdated = service.saveOrUpdateProduct(productToUpdate).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "something wrong with update method, maybe take a look on your request "));
    return new ResponseEntity<>(productUpdated,HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Long id){
        Product product = service.getProductById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id product not found " + id));
        Boolean productDeleted = service.deleteProduct(id);
        return new ResponseEntity<>(productDeleted,HttpStatus.OK);
    }
    //name
    //barcode
}

