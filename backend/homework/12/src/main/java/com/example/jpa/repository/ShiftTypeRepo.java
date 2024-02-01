package com.example.jpa.repository;

import com.example.jpa.entity.ShiftType;
import com.example.jpa.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiftTypeRepo extends JpaRepository <ShiftType, UUID> {
}
