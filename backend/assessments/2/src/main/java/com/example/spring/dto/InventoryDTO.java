package com.example.spring.dto;

import com.example.spring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InventoryDTO {
    private List<Product> products;
}
