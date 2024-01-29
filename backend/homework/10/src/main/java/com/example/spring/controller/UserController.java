package com.example.spring.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring.exception.custom.InvalidAuthException;
import com.example.spring.model.User;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    List<User> userList = new ArrayList<>();

    /**
     * Adds a new user to the memory storage.
     *
     * @param user The user object to be added.
     * @return ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        log.error("Adding a new user to memory");
        userList.add(user);
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
    public User getUser(@PathVariable int id){
        User user = null;
        try{
            user = userList.get(id);
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

    @GetMapping("/search/user")
    public User searchUser(@RequestParam String name){
        log.info("searching user");
        User temp = null;
        try {
            for (User user: userList){
                if (user.getName().equals(name)){
                    temp = user;
                }
            }
        }catch (InvalidAuthException e){
            throw new InvalidAuthException("no user found");
        }

        return temp;
    }
}
