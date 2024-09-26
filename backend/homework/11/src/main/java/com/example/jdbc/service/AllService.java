package com.example.jdbc.service;

import com.example.jdbc.DAO.ShiftDAO;
import com.example.jdbc.DAO.ShiftTypeDAO;
import com.example.jdbc.DAO.ShiftUserDAO;
import com.example.jdbc.DAO.UserDAO;
import com.example.jdbc.DTO.AllDTO;
import com.example.jdbc.DTO.ShiftDTO;
import com.example.jdbc.DTO.ShiftTypeDTO;
import com.example.jdbc.model.Shift;
import com.example.jdbc.model.ShiftType;
import com.example.jdbc.model.ShiftUser;
import com.example.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AllService {


    @Autowired
    UserDAO userDAO;
    @Autowired
    ShiftDAO shiftDAO;
    @Autowired
    ShiftTypeDAO shiftTypeDAO;
    @Autowired
    ShiftUserDAO shiftUserDAO;

    public void addAll(AllDTO allDTO) {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        User userObj = new User(allDTO.getUsername(), allDTO.getLoggedIn(), allDTO.getTimeZone(), allDTO.getTenantId(), createdAt, allDTO.getCreatedBy(), allDTO.getUpdatedBy(), updatedAt);
        userDAO.saveUser(userObj);
        ShiftTypeDTO newShiftType = new ShiftTypeDTO(allDTO.getUqName(), allDTO.getDescription(), allDTO.isActive(),allDTO.getCreatedAt(),allDTO.getCreatedBy(),allDTO.getUpdatedBy(),allDTO.getUpdatedAt(), allDTO.getTimeZone(), UUID.fromString(allDTO.getTenantId()));
        shiftTypeDAO.saveShiftType(newShiftType);
        ShiftDTO newShifts = new ShiftDTO(allDTO.getName(), allDTO.getDateStart(), allDTO.getDateEnd(), allDTO.getTimeStart(),
                allDTO.getTimeEnd(), allDTO.getCreatedAt(),allDTO.getCreatedBy(),allDTO.getUpdatedBy(), allDTO.getUpdatedAt(), allDTO.getTimeZone(), UUID.fromString(allDTO.getTenantId()));
        shiftDAO.saveShift(newShifts);
        ShiftUser newShiftUser = new ShiftUser(allDTO.getTenantId(), allDTO.getCreatedBy(), allDTO.getUpdatedBy(), allDTO.getCreatedAt(), allDTO.getUpdatedAt());
        shiftUserDAO.saveShiftUser(newShiftUser);
    }
}