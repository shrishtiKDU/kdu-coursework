package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;


@Entity
@Data
@Table(name = "shift")
public class Shift extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shift_id")
    private UUID shiftId;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="shiftTypeId",
            joinColumns ={
                    @JoinColumn(name = "shift_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "shift_type_id")
            }
    )
    private ShiftType shiftType;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String timeZone;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
}
