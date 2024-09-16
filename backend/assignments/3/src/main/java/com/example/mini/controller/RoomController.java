package com.example.mini.controller;

import com.example.mini.DTO.AddRoomRequest;
import com.example.mini.DTO.RoomResponse;
import com.example.mini.mapper.RoomMapper;
import com.example.mini.service.RoomService;
import com.example.mini.validators.LongtoStr;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/api/v1/room")
    public ResponseEntity<RoomResponse> addRoom(@RequestParam String houseId, @RequestBody AddRoomRequest addRoomRequest, HttpServletRequest request){
        if(!LongtoStr.isParsable(houseId))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        RoomResponse roomResponse = roomService.addRoom(Long.parseLong(houseId),addRoomRequest.getRoomName());
        return new ResponseEntity<>(roomResponse, HttpStatus.OK);
    }

}
