package com.example.jdbc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftUserDTO {

    private UUID tenantId;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
}
