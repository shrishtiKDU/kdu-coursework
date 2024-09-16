package com.example.mini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "kickstonr_id")
    private String kickstonId;
    @Column(name = "device_username")
    private String deviceUsername;
    @Column(name = "device_password")
    private String devicePassword;
    @Column(name = "manufacture_date")
    private String manufactureDate;
    @Column(name = "manufacture_place")
    private String manufacturePlace;
}
