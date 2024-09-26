package com.example.jdbc.DAO;


import com.example.jdbc.mapper.ShiftUserRowMapper;
import com.example.jdbc.model.ShiftUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftUserDAO {
    final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void saveShiftUser(ShiftUser shiftUser){
        String sql= "INSERT INTO shiftuser ( tenantId,createdBy,updatedBy) VALUES(?,?,?)";
        jdbcTemplate.update(sql, shiftUser.getTenantId(), shiftUser.getCreatedBy(),shiftUser.getUpdatedBy());
    }
    public ShiftUser getShiftUserById(UUID id){
        String  sql = "SELECT * FROM shiftuser WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new ShiftUserRowMapper(),id);
    }
}

