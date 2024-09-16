package com.example.mini.controller;

import com.example.mini.DTO.UserRegisterRequest;
import com.example.mini.DTO.UserResponseDTO;
import com.example.mini.entity.User;
import com.example.mini.mapper.UserMapper;
import com.example.mini.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/v1/auth/register")
    public ResponseEntity addUser(@RequestBody UserRegisterRequest userDTO){
        UserResponseDTO userResponseDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

}


