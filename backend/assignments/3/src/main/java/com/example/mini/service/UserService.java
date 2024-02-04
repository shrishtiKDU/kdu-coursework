package com.example.mini.service;

import com.example.mini.DAO.UserDAO;
import com.example.mini.DTO.UserRegisterRequest;
import com.example.mini.DTO.UserResponseDTO;
import com.example.mini.Util.JWTUtil;
import com.example.mini.entity.User;
import com.example.mini.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private final JWTUtil jwtUtil;

    public UserService(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    public UserResponseDTO addUser(UserRegisterRequest userRegisterRequest){
        User user = userMapper.mapUserDTO(userRegisterRequest);
        userDAO.save(user);
        String token =jwtUtil.getTokenNew(userRegisterRequest);
        return new UserResponseDTO("user added",token);

    }


}
