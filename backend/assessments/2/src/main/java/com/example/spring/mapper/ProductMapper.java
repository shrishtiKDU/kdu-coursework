package com.example.spring.mapper;

import com.example.spring.dto.ProductDTO;
import com.example.spring.model.Product;

public class ProductMapper {
    public static Product mapToProduct(ProductDTO productDTO){
        Product product = new Product();
        return product;
    }
}
