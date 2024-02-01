package com.example.jpa.service;


import com.example.jpa.entity.Shift;
import com.example.jpa.entity.ShiftType;
import com.example.jpa.entity.ShiftUser;
import com.example.jpa.repository.ShiftUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ShiftUserService {

    private ShiftUserRepo shiftUserRepo;

    @Autowired
    public ShiftUserService(ShiftUserRepo shiftUserRepo) {
        this.shiftUserRepo = shiftUserRepo;
    }
    public ShiftUser saveShiftUser(ShiftUser shiftUser){
        return shiftUserRepo.save(shiftUser);
    }

    public void deleteShiftUser(UUID id){
        shiftUserRepo.deleteAllById(Collections.singleton(id));
    }
}
