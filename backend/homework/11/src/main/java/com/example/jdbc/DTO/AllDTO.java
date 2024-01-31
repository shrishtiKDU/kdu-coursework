package com.example.jdbc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDTO {


    private String username;
    private int loggedIn;


    //shiftTypes
    //private String shiftTypesId;
    private String uqName;
    private String description;
    private boolean active;




    //Shifts
    //private String shiftsId;
//    private String shiftTypeId;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalTime timeStart;
    private LocalTime timeEnd;


    //shiftUser

    //common fields
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    private Date createdAt;
    private Date updatedAt;

}
