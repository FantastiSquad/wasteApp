package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String Email);
    Optional<User> getUserByUsername(String userName);
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
    Optional <User> saveOrUpdateUser(User user);
    List <User> getUsers();
}
