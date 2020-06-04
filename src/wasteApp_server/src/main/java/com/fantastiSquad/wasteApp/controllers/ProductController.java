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
    public ResponseEntity<List<Product>> getProducts(){
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
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable(value = "id") Long id, @RequestBody Product product){
    Product productUpdated = service.saveOrUpdateProduct(product).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "something wrong with update method, maybe take a look on your request "));
    return new ResponseEntity<>(productUpdated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.deleteProduct(id),HttpStatus.OK);
    }
    //nameAndCodeBarre
    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByNameOrBarCode(@RequestParam("keyword") String keyword){
        List<Product> products = service.getProductsByNameOrBarcode(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    //barcode
    @GetMapping("/barcode")
    public ResponseEntity<List<Product>> getProductsByBarCode(@RequestParam("keyword") String keyword){
        List<Product> products = service.getProductsByBarcode(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}

