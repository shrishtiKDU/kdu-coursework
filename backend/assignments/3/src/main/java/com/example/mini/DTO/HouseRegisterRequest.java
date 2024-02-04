package com.example.mini.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseRegisterRequest {
    private String address;
    private String houseName;
}
