package com.example.jpa.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
public class ShiftUserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID shiftId;
    private UUID userId;
    private UUID tenantId;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
}
