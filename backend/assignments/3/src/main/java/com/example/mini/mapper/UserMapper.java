package com.example.mini.mapper;

import com.example.mini.DTO.UserRegisterRequest;
import com.example.mini.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public User mapUserDTO(UserRegisterRequest userRegisterRequest){
        User user = new User();
        user.setUserName(userRegisterRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        user.setEmail(userRegisterRequest.getEmailId());
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setName(userRegisterRequest.getName());

        return user;
    }
}

