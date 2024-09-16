package com.example.mini.controller;


import com.example.mini.DTO.AddDeviceRequest;
import com.example.mini.DTO.DeviceRegisterRequest;
import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.mapper.DeviceMapper;
import com.example.mini.service.DeviceService;
import com.example.mini.validators.LongtoStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;


    @PostMapping("/api/v1/device/register")
    public ResponseEntity<GlobalResponseDTO> registerDevice(@RequestBody DeviceRegisterRequest deviceRegisterRequest){
        GlobalResponseDTO globalResponseDTO =deviceService.registerDevice(deviceRegisterRequest);
        return new ResponseEntity<>(globalResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/api/v1/device/add")
    public ResponseEntity<GlobalResponseDTO> addDeviceInHouse(@RequestBody AddDeviceRequest addDeviceRequest){
        if(!LongtoStr.isParsable(addDeviceRequest.getHouseId()) || !LongtoStr.isParsable(addDeviceRequest.getRoomId()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       GlobalResponseDTO globalResponseDTO = deviceService.addDevice(addDeviceRequest);
        return new ResponseEntity<>(globalResponseDTO,HttpStatus.OK);
    }

}
