package com.example.spring.dao;


import com.example.spring.model.Product;
import com.example.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    @Query(value = "SELECT p from my_user p WHERE p.id=?1")
    User getUserById(int id);
}
