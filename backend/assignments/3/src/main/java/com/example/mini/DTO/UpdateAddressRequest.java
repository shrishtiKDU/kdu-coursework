package com.example.mini.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAddressRequest {
    private String address;
}
