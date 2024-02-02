package com.example.spring.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    private String productName;
    private String productDescription;
    private int price;
    private int quantity;
    private int threshold;
}
