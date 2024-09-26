package com.example.spring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_amount")
    private int amount;
    @Column(name = "order_address")
    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne()
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
