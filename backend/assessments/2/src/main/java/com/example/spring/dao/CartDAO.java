package com.example.spring.dao;

import com.example.spring.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT c FROM cart c WHERE c.cartId =?1")
    Cart getCartById(int id);
}
