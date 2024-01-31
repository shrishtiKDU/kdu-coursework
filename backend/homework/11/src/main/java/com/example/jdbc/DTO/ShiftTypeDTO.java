package com.example.jdbc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
public class ShiftTypeDTO {

    private String name;
    private String description;
    private boolean active;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
    private String timeZone;
    private UUID tenantId;
}
