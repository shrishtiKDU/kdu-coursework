package com.example.mini.controller;

import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.DTO.HouseRegisterRequest;
import com.example.mini.DTO.HouseResponseDTO;
import com.example.mini.entity.House;
import com.example.mini.mapper.HouseMapper;
import com.example.mini.service.HouseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
@RequestMapping("/api/v1")
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping("/house")
    public ResponseEntity<HouseResponseDTO> addHouse(@RequestBody HouseRegisterRequest houseRegisterRequest, HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization").substring(7);
      HouseResponseDTO houseResponseDTO = houseService.addHouse(houseRegisterRequest,token);
        return new ResponseEntity<>(houseResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/house/{houseId}/add-user")
    public ResponseEntity addUserToHouse(@RequestParam String houseId, @RequestBody String userName, HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        GlobalResponseDTO userHouseDTO = houseService.addUserToHouse(String.valueOf(Long.parseLong(houseId)),userName,token);
        return new ResponseEntity<>(userHouseDTO,HttpStatus.OK);
    }

}
