package com.example.jpa.repository;

import com.example.jpa.entity.Shift;
import com.example.jpa.entity.Tenant;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShiftRepo extends JpaRepository<Shift, UUID> {
    @Query(value="SELECT s FROM shift s WHERE s.startDate = :startDate AND s.endDate = :endDate ORDER BY s.name", nativeQuery = true)
    List<Shift> findTop3OrderedShifts(
            @Param("dateStart") LocalDate startDate, @Param("dateEnd") LocalDate endDate);
}
