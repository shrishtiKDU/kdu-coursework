package com.example.spring.dto;

import com.example.spring.model.Address;
import com.example.spring.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String role;
    private List<Address> addresses;

}