package com.example.mini.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterRequest {
    private String username;
    private String password;
    private String name;
    private String role;
    private String firstName;
    private String lastName;
    private String emailId;
}
