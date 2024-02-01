package com.example.jpa.service;

import com.example.jpa.entity.Shift;
import com.example.jpa.repository.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShiftService {
    private final ShiftRepo shiftRepo;

    @Autowired
    public ShiftService(ShiftRepo shiftRepo){
        this.shiftRepo=shiftRepo;
    }
    public Shift saveShift (Shift shift){
        return shiftRepo.save(shift);
    }
    public List<Shift> getAllShifts(){
        return shiftRepo.findAll();
    }

    public List<Shift> findTop3Shifts(LocalDate dateStarted, LocalDate dateEnded){
        return shiftRepo.findTop3OrderedShifts(dateStarted, dateEnded);
    }

}