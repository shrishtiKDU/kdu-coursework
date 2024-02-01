package com.example.jpa.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userName;
    private int loggedIn;
    private String timeZone;
    private UUID tenantId;
    private Date createdAt;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
}
