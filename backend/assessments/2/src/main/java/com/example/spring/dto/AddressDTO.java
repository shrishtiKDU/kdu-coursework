package com.example.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private String city;
    private String country;
    private String state;
    private int postalCode;
    private String nickname;
}


