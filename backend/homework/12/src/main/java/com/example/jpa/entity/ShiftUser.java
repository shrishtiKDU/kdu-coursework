package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Entity
@Data
@Table(name = "shiftuser")
public class ShiftUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shift_user_id")
    private UUID shiftUserId;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

}
