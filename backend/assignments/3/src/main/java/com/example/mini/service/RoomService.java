package com.example.mini.service;

import com.example.mini.DAO.HouseDAO;
import com.example.mini.DAO.RoomDAO;
import com.example.mini.DTO.RoomResponse;
import com.example.mini.Exception.GlobalException;
import com.example.mini.entity.House;
import com.example.mini.entity.Room;
import com.example.mini.mapper.RoomMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomDAO roomDAO;
    @Autowired
    HouseDAO houseDAO;
    @Autowired
    RoomMapper roomMapper;


    @Transactional
    public RoomResponse addRoom(Long id, String name)  {

        Optional<House> optionalHouse = houseDAO.findById(String.valueOf(id));
        if (optionalHouse.isPresent()) {
            House house = optionalHouse.get();
            Room room = roomMapper.mapRoomDTO(name, house);
            roomDAO.save(room);
            return new RoomResponse("Room added ", room, HttpStatus.OK);
        } else {
            throw new GlobalException("not found");
        }
    }


}
