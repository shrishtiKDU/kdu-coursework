package com.example.mini.DTO;

import com.example.mini.entity.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class HouseResponseDTO {
    private String message;
    private House house;
    private HttpStatus httpStatus;
}
