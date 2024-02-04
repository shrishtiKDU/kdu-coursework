package com.example.mini.service;

import com.example.mini.DAO.DeviceDAO;
import com.example.mini.DAO.HouseDAO;
import com.example.mini.DAO.InventoryDAO;
import com.example.mini.DTO.AddDeviceRequest;

import com.example.mini.DTO.DeviceRegisterRequest;
import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.Exception.GlobalException;
import com.example.mini.entity.Device;
import com.example.mini.entity.House;
import com.example.mini.entity.Inventory;
import com.example.mini.entity.Room;
import com.example.mini.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    HouseDAO houseDAO;

    public GlobalResponseDTO addDevice(AddDeviceRequest addDeviceRequest){

        Optional<Device> newDevice = deviceDAO.findByKickstonId(addDeviceRequest.getKickstonId());
        Optional<House> newHouse = houseDAO.findById(String.valueOf(Long.parseLong(addDeviceRequest.getHouseId())));

        if(newHouse.isPresent() && newDevice.isPresent()){
            House house = newHouse.get();
            Device device = newDevice.get();

            Long roomId = Long.parseLong(addDeviceRequest.getRoomId());
            Optional<Room> optionalRoom = house.getRooms().stream()
                    .filter(room -> room.getRoomId()==roomId)
                    .findFirst();

            if (optionalRoom.isPresent()) {
                Room room = optionalRoom.get();
                device.setRoom(room);
                deviceDAO.save(device);
                return new GlobalResponseDTO("Device added successfully!", "Room: ".concat(addDeviceRequest.getRoomId()), HttpStatus.OK);
            } else {
                throw new GlobalException("Room with the given id not found!");
            }

        }
        else{
            if(newDevice.isEmpty() && newHouse.isEmpty())
                throw new GlobalException("House and Device with given id not found!");
            else if (newHouse.isEmpty()) {
                throw new GlobalException("House with given id not found!");
            }
            else{
                throw new GlobalException("Device with given id not found!");
            }
        }


    }

    public GlobalResponseDTO registerDevice(DeviceRegisterRequest deviceRegisterRequest){
        Optional<Inventory> optionalInventory = inventoryDAO.findByKickstonId(deviceRegisterRequest.getKickstonId());
        if(optionalInventory.isPresent() && optionalInventory.get().getDeviceUsername().equals(deviceRegisterRequest.getDeviceUsername())){
            Inventory inventory = optionalInventory.get();
            if(deviceRegisterRequest.getDevicePassword().equals(inventory.getDevicePassword())){
                Device device = deviceMapper.mapDeviceDTO(deviceRegisterRequest);
                deviceDAO.save(device);
                return new GlobalResponseDTO("Device registered successfully!","Kickston id : ".concat(device.getKickstonId()), HttpStatus.OK);
            }
            else{
                throw new GlobalException("Incorrect password!");
            }
        }
        else{
            throw new GlobalException("Device not found in inventory!");
        }
    }
}
