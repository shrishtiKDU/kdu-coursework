package com.example.spring.dao;


import com.example.spring.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Integer> {
}
