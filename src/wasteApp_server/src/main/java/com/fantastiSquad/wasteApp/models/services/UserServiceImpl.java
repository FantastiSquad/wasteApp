package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.User;
import com.fantastiSquad.wasteApp.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> saveOrUpdateUser(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
