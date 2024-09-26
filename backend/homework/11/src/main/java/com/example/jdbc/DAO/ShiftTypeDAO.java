package com.example.jdbc.DAO;


import com.example.jdbc.DTO.ShiftTypeDTO;
import com.example.jdbc.mapper.ShiftTypeRowMapper;
import com.example.jdbc.model.ShiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftTypeDAO {
    final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftTypeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void saveShiftType(ShiftTypeDTO shiftType){
        String sql = "INSERT INTO shifttype (name,description,active,created_by,updated_by,time_zone,tenant_id) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, shiftType.getName(), shiftType.getDescription(), shiftType.isActive(),
                shiftType.getCreatedBy(), shiftType.getUpdatedBy(), shiftType.getTimeZone(), shiftType.getTenantId());
    }

    // INSERT INTO shifttype (
    //    name,
    //    description,
    //    active,
    //    created_by,
    //    updated_by,
    //    time_zone,
    //    tenant_id
    //) VALUES (

    public ShiftType getShiftTypeById(UUID id){
        String sql = "SELECT * FROM shifttype WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new ShiftTypeRowMapper(), id);
    }



}

