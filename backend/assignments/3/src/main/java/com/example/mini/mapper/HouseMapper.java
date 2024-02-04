package com.example.mini.mapper;

import com.example.mini.DTO.HouseRegisterRequest;
import com.example.mini.entity.House;
import com.example.mini.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    public static House mapHouseDTO(HouseRegisterRequest houseRegisterRequest, User user){
        House house = new House();
        house.setHouseName(houseRegisterRequest.getHouseName());
        house.setAddress(houseRegisterRequest.getAddress());
        house.getUsers().add(user);
        return house;
    }
}


// public static User mapUserDTO(UserDTO userDTO){
//        User user = new User();
//        user.setUserName(userDTO.getUsername());
//        user.setPassword(userDTO.getPassword());
//        user.setEmail(userDTO.getEmail());
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setName(userDTO.getName());
//
//        return user;
//    }