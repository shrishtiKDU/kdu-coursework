package com.example.jdbc.DAO;


import com.example.jdbc.DTO.ShiftDTO;
import com.example.jdbc.mapper.ShiftRowMapper;
import com.example.jdbc.mapper.UserRowMapper;
import com.example.jdbc.model.Shift;
import com.example.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftDAO {

    final JdbcTemplate jdbcTemplate;
    public ShiftDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void saveShift(ShiftDTO shift){
        String sql = "INSERT INTO shift (name, dateStart, dateEnd, timeStart,\n" +
                "    timeEnd,\n" +
                "    createdBy,\n" +
                "    updatedBy,\n" +
                "    timeZone,\n" +
                "    tenantId) VALUES(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, shift.getName(),
        shift.getDateStart(), shift.getDateEnd(), shift.getTimeStart(), shift.getTimeEnd(),
                shift.getCreatedBy(), shift.getUpdatedBy(), shift.getTimeZone()
        ,shift.getTenantId());
    }

    public Shift getShiftByid(UUID id){
        String sql = "SELECT * FROM shift WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new ShiftRowMapper(),id);
    }
}

