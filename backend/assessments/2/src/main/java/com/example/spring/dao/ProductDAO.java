package com.example.spring.dao;


import com.example.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query(value = "UPDATE product p SET quantity=?1 WHERE productId=?2")
    Product updateProduct(int newQuantity, int productId);

    @Query(value = "SELECT b from product b WHERE b.id=?1")
    Product getProductById(int id);
}
