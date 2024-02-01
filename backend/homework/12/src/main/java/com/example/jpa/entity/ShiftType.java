package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "shifttype")
public class ShiftType extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shift_type_id")
    private UUID shiftTypeId;
    private String name;
    private String description;
    private boolean active;
    private String timeZone;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
}
