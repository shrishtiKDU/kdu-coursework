package com.example.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "threshold")
    private int threshold;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
