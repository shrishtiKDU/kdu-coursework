package com.example.mini.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddDeviceRequest {
    private String houseId;
    private String roomId;
    private String kickstonId;
}
