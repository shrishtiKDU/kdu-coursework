package com.example.mini.mapper;


import com.example.mini.DAO.InventoryDAO;
import com.example.mini.DTO.InventoryRequest;
import com.example.mini.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {



    public static Inventory inventoryRequestMapper(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setDeviceUsername(inventoryRequest.getDeviceUsername());
        inventory.setDevicePassword(inventoryRequest.getDevicePassword());
        inventory.setManufactureDate(inventoryRequest.getManufactureDateTime());
        inventory.setManufacturePlace(inventoryRequest.getManufactureFactoryPlace());
        return inventory;
    }
}
