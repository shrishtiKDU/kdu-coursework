package com.example.mini.DAO;

import com.example.mini.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Integer> {

    @Query
    Optional<Inventory> findByKickstonId(String kickstonId);
}
