package com.example.spring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;
    @Column(name ="city")
    private String city;
    @Column(name ="country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "code")
    private int postalCode;
    @Column(name = "nickname")
    private String nickname;
}
