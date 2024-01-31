package com.example.jdbc.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ShiftDTO {

    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
    private String timeZone;
    private UUID tenantId;
}
