package com.example.mini.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponseDTO {
    private String message;
    private String info;
    private HttpStatus httpStatus;


}
