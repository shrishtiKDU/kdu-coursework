package com.example.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "my_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses;

}
