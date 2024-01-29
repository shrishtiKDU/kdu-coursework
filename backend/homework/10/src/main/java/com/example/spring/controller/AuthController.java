package com.example.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    /**
     * Handles the login request for a person.
     *
     * @return ResponseEntity containing a success message and HTTP status code 201 (CREATED).
     */
    @GetMapping("/person/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("test login success", HttpStatus.CREATED);
    }
}
