package com.example.spring.dto;


import com.example.spring.model.Product;
import com.example.spring.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDTO {
    private int cartId;
    private List<Product> products;
    private User user;

}

