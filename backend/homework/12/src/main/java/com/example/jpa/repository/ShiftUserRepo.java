package com.example.jpa.repository;

import com.example.jpa.entity.Shift;
import com.example.jpa.entity.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiftUserRepo extends JpaRepository<ShiftUser, UUID> {

}