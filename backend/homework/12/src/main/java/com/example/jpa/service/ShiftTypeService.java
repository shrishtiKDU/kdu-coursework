package com.example.jpa.service;

import com.example.jpa.entity.Shift;
import com.example.jpa.entity.ShiftType;
import com.example.jpa.repository.ShiftRepo;
import com.example.jpa.repository.ShiftTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShiftTypeService {

    private final ShiftTypeRepo shiftTypeRepo;


    @Autowired
    public ShiftTypeService(ShiftTypeRepo shiftTypeRepo) {
        this.shiftTypeRepo = shiftTypeRepo;
    }
    public ShiftType saveShiftType (ShiftType shiftType){
        return shiftTypeRepo.save(shiftType);
    }
}
