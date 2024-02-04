package com.example.mini.service;

import com.example.mini.DAO.InventoryDAO;
import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.DTO.InventoryRequest;
import com.example.mini.DTO.InventoryResponse;
import com.example.mini.Util.JSONutil;
import com.example.mini.entity.Inventory;
import com.example.mini.mapper.InventoryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    private final JSONutil jsonutil;

    public InventoryService(JSONutil jsonutil) {
        this.jsonutil = jsonutil;
    }


    public InventoryResponse getAllInventory() throws JsonProcessingException {
        List<Inventory> inventoryList = inventoryDAO.findAll();
        String inventory= jsonutil.convertListToJSONString(inventoryList);
        return new InventoryResponse(inventory, HttpStatus.OK);
    }


    public GlobalResponseDTO addItemToInventory(InventoryRequest inventory){
       Inventory newInventory = InventoryMapper.inventoryRequestMapper(inventory);
       inventoryDAO.save(newInventory);
        return new GlobalResponseDTO("Device added successfully!","Kickston ID : ".concat(inventory.getKickstonId()), HttpStatus.OK);
    }
}
