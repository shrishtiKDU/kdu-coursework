package com.example.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftUser {

    private UUID id;
    private UUID shiftId;
    private UUID userId;
    private UUID tenantId;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;

    public ShiftUser(String tenantId, String createdBy, String updatedBy, Date createdAt, Date updatedAt) {
    }
}
