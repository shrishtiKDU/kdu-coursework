package com.example.mini.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryRequest {
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
    private String manufactureDateTime;
    private String manufactureFactoryPlace;
}
