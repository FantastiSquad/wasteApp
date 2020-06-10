package com.fantastiSquad.wasteApp.controllers;


import com.fantastiSquad.wasteApp.models.entities.Product;
import com.fantastiSquad.wasteApp.models.entities.User;
import com.fantastiSquad.wasteApp.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        User userToReturn = this.userService.getUserById(id)
                .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id : " + id)
                );
        return new ResponseEntity<User>(userToReturn, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email) {
        User userToReturn = this.userService.getUserByEmail(email)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this email : " + email)
                );
        return new ResponseEntity<User>(userToReturn, HttpStatus.OK);
    }

     @GetMapping("/{id}/productBin")
     public ResponseEntity<Set<Product>> getAllProductsByUserProductBin(@PathVariable(name = "id") Long id) {
         User userToReturn = this.userService.getUserById(id)
                 .orElseThrow(
                         () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id : " + id)
                 );
         return new ResponseEntity<Set<Product>>(userToReturn.getProductBin().getProducts(), HttpStatus.OK);
     }

    @GetMapping("/{id}/basket")
    public ResponseEntity<Set<Product>> getAllProductsByUserBasket(@PathVariable(name = "id") Long id) {
        User userToReturn = this.userService.getUserById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id : " + id)
                );
        return new ResponseEntity<Set<Product>>(userToReturn.getBasket().getProducts(), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<User> updateUser (@Valid @RequestBody User userUpdates) {
        User userUpdated = this.userService.saveOrUpdateUser(userUpdates).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something goes wrong when trying to update user")
        );
        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User userToSave) {
        User userSaved = this.userService.saveOrUpdateUser(userToSave).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something goes wrong when trying to save user")
        );
        return new ResponseEntity<User>(userSaved, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "id") Long id) {
       User userToDelete = this.userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id : " + id)
        );
       // Need to update user to empty productBin and basket objects before deleting
        userToDelete.getProductBin().setProducts(new HashSet<Product>());
        User userToDeleteUpdate = this.userService.saveOrUpdateUser(userToDelete).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something goes wrong when trying to delete user")
        );
        this.userService.deleteUser(id);
       return this.userService.getUserById(id).isPresent() ? new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST) : new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }


}