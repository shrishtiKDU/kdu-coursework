package com.example.spring.mapper;

import com.example.spring.dto.CartDTO;
import com.example.spring.dto.ProductDTO;
import com.example.spring.model.Cart;
import com.example.spring.model.Product;

public class CartMapper {

    public static Cart mapToCart(CartDTO cartDTO){
        Cart cart = new Cart();
        return cart;
    }
}
