package com.example.spring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;;
import lombok.Data;;


@Entity
@Data
@AllArgsConstructor
@Table(name = "person")
public class Person {
    private String name;
    private String userName;
    private String password;
    private String role;
}
