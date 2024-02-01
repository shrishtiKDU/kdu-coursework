package com.example.jpa.DTO;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ShiftTypeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
