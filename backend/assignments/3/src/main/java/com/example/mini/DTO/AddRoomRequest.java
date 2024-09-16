package com.example.mini.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddRoomRequest {
    private String roomName;
}
