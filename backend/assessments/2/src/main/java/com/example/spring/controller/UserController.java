package com.example.spring.controller;

import com.example.spring.service.UserAdditionService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring.exception.custom.InvalidAuthException;
import com.example.spring.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserAdditionService userAdditionService;


    /**
     * Adds a new user to the memory storage.
     *
     * @param user The user object to be added.
     * @return ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        log.error("Adding a new user to memory");
        userAdditionService.createUser(user);
        log.info(user.getName());
        return ResponseEntity.ok("User Added successfully!");
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user object with the specified ID.
     * @throws InvalidAuthException if the ID is out of bounds (no user with that ID).
     */


    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id){
        Optional<User> user = null;
        try{
            user = userAdditionService.getUserById(id);
        }catch(IndexOutOfBoundsException ex){
            throw new InvalidAuthException("No data of id - " + id + "in storage");
        }
        return user;
    }

    /**
     * Searches for a user by their name.
     *
     * @param name The name of the user to search for.
     * @return The user object with the specified name.
     * @throws InvalidAuthException if no user with the given name is found.
     */

}
