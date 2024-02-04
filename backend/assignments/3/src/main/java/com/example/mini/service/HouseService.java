package com.example.mini.service;

import com.example.mini.DAO.HouseDAO;
import com.example.mini.DAO.UserDAO;
import com.example.mini.DTO.GlobalResponseDTO;
import com.example.mini.DTO.HouseRegisterRequest;
import com.example.mini.DTO.HouseResponseDTO;
import com.example.mini.Exception.GlobalException;
import com.example.mini.Util.JSONutil;
import com.example.mini.Util.JWTUtil;
import com.example.mini.entity.House;
import com.example.mini.entity.User;
import com.example.mini.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    HouseDAO houseDAO;

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    UserDAO userDAO;
    private final JWTUtil jwtUtil;
    private final JSONutil jsonUtil;

    @Autowired
    public HouseService(JWTUtil jwtUtil, JSONutil jsonUtil) {
        this.jwtUtil = jwtUtil;
        this.jsonUtil = jsonUtil;
    }

    public HouseResponseDTO addHouse(HouseRegisterRequest houseRegisterRequest, String token) throws Exception {
        String username = jwtUtil.decodeToken(token);
        Optional<User> optionalUser = userDAO.findByUserName(username);
        if (optionalUser.isEmpty())
            throw new Exception("not found");

        User user = optionalUser.get();
        user.setRole("ROLE_ADMIN");
        House house = houseMapper.mapHouseDTO(houseRegisterRequest, user);
        userDAO.save(user);
        houseDAO.save(house);
        return new HouseResponseDTO("House added successfully!", house, HttpStatus.OK);
    }

    public GlobalResponseDTO addUserToHouse(String houseId, String userName, String token) {
        String userAdmin = jwtUtil.decodeToken(token);
        Optional<User> optionalUser = userDAO.findByUserName(userAdmin);
        if (optionalUser.isEmpty())
            throw new GlobalException("User Not found");

        User user = optionalUser.get();
        if (user.getRole().equals("ROLE_ADMIN")) {
            Optional<House> optionalHouse = houseDAO.findById(houseId);
            if (optionalHouse.isPresent()) {
                House house = optionalHouse.get();
                Optional<User> optionalUserModel = userDAO.findByUserName(userName);
                if (optionalUserModel.isEmpty())
                    throw new GlobalException("User Not found");


                house.getUsers().add(optionalUserModel.get());
                return new GlobalResponseDTO("User added successfully", "Username : ".concat(userName), HttpStatus.OK);
            } else {
                throw new GlobalException("House with not found");
            }
        } else {
            throw new GlobalException("Given user is not admin!");
        }
    }


}

