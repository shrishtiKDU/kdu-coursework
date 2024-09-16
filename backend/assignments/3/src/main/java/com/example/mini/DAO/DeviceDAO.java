package com.example.mini.DAO;

import com.example.mini.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Integer> {


//    @Query(value = "SELECT d FROM Device WHERE d.kickstonId = ?1")
//    public Device findByKickstonId(String id);
    @Query
    Optional<Device> findByKickstonId(String kickstonId);

}
