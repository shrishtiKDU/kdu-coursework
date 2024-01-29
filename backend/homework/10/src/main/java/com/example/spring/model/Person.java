package com.example.spring.model;


import lombok.AllArgsConstructor;;
import lombok.Data;;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String userName;
    private String password;
    private String role;
}
