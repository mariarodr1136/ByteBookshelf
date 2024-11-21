package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.CreditCard;
import com.example.model.User;
import com.example.repository.CreditCardRepository;
import com.example.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a credit card for a user (POST)
    @PostMapping("/{username}")
    public ResponseEntity<?> createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            creditCard.setUser(user); // Associate credit card with user
            CreditCard savedCard = creditCardRepository.save(creditCard);
            return ResponseEntity.ok(savedCard); // Return the saved credit card details
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}