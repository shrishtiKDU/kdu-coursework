package com.example.spring.service;


import com.example.spring.dao.InventoryDAO;
import com.example.spring.model.Inventory;
import com.example.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryDAO inventoryDAO;

    public Inventory createInventory(Inventory inventory){
        return inventoryDAO.save(inventory);
    }

}
