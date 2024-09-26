package com.example.jdbc.controller;


import com.example.jdbc.DTO.AllDTO;
import com.example.jdbc.DTO.ShiftDTO;
import com.example.jdbc.DTO.ShiftTypeDTO;
import com.example.jdbc.DTO.UserDTO;
import com.example.jdbc.model.Shift;
import com.example.jdbc.model.ShiftType;
import com.example.jdbc.model.ShiftUser;
import com.example.jdbc.model.User;
import com.example.jdbc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ShiftTypeService shiftTypeService;

    @Autowired
    ShiftUserService shiftUserService;

    @Autowired
    ShiftService shiftService;

    @Autowired
    AllService allService;

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser(){
        try {
            List<User> users = userService.getAllUser();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String name){
        try{
            List<User> users = userService.getUserByName(name);
            return ResponseEntity.ok(users);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search/{id}")
    public User getUserById(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        return  userService.getUserById(uid);
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("user addedd succes");
    }

    @PutMapping("/user/{id}")
    public int updateUserName(@PathVariable UUID id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO.getUserName());
    }


    //  shift type controller


    @PostMapping("/shiftType")
    public ResponseEntity<String> addShiftType(@RequestBody ShiftTypeDTO shiftType){
        String message = "addedd shift type";
        shiftTypeService.addShiftType(shiftType);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/shiftType/{id}")
    public ShiftType getShiftTypeById(@PathVariable UUID id){
        return shiftTypeService.getShiftTypeById(id);
    }

    // shift User controller

    @PostMapping("/shiftUser")
    public ResponseEntity<String> addShiftUser(@RequestBody ShiftUser shiftUser){
        String message = "add the shift user success";
        shiftUserService.addShiftUser(shiftUser);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/shiftUser/{id}")
    public ShiftUser getShiftUserById(@PathVariable  UUID id){
        return shiftUserService.getShiftUserById(id);
    }



    // SHIFT  CONTROLLER
    @PostMapping("/shift")
    public ResponseEntity<String> addShift(@RequestBody ShiftDTO shiftdto){
        String message = "add the shift user success";
        shiftService.addShift(shiftdto);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/shift/{id}")
    public Shift getShiftById(@PathVariable UUID id){
        return shiftService.getShiftById(id);
    }


    @PostMapping("/all")
    public ResponseEntity<String> addAllValues(@RequestBody AllDTO allDTO)
    {
        allService.addAll(allDTO);
        return ResponseEntity.ok("All the Values Added Successfully");
    }



}
