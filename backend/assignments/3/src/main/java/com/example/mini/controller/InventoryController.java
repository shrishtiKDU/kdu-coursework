package com.example.mini.controller;

import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.DTO.InventoryRequest;
import com.example.mini.DTO.InventoryResponse;
import com.example.mini.service.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/api/v1/inventory")
    public ResponseEntity<GlobalResponseDTO> getInventoryItems(@RequestBody InventoryRequest inventoryRequest) {
        GlobalResponseDTO responseInfoDTO = inventoryService.addItemToInventory(inventoryRequest);
        return new ResponseEntity<>(responseInfoDTO, HttpStatus.OK);
    }

    @PostMapping("/api/v1/inventory")
    public ResponseEntity<InventoryResponse > addItemToInventory(@RequestBody InventoryRequest inventoryRequest) throws JsonProcessingException {
        InventoryResponse inventoryResponse = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventoryResponse, HttpStatus.OK);

    }
}
