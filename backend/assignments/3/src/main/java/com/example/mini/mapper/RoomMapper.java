package com.example.mini.mapper;

import com.example.mini.entity.House;
import com.example.mini.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public static Room mapRoomDTO(String roomName, House house){
        Room room=new Room();
        room.setRoomName(roomName);
        room.setHouse(house);
        return room;
    }
}