package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setUsername(userDetails.getUsername());
            updatedUser.setPassword(userDetails.getPassword());
            updatedUser.setName(userDetails.getName());
            updatedUser.setHomeAddress(userDetails.getHomeAddress());
            return ResponseEntity.ok(userRepository.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{username}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable String username, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            User updatedUser = user.get();
            if (userDetails.getUsername() != null) {
                updatedUser.setUsername(userDetails.getUsername());
            }
            if (userDetails.getPassword() != null) {
                updatedUser.setPassword(userDetails.getPassword());
            }
            if (userDetails.getName() != null) {
                updatedUser.setName(userDetails.getName());
            }
            if (userDetails.getHomeAddress() != null) {
                updatedUser.setHomeAddress(userDetails.getHomeAddress());
            }
            return ResponseEntity.ok(userRepository.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}