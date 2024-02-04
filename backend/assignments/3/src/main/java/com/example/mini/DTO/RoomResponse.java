package com.example.mini.DTO;

import com.example.mini.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private String message;
    private Room room;
    private HttpStatus httpStatus;
}
