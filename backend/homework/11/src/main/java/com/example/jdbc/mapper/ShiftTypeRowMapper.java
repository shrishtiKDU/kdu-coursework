package com.example.jdbc.mapper;

import com.example.jdbc.model.ShiftType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftTypeRowMapper implements RowMapper<ShiftType> {

    @Override
    public ShiftType mapRow(ResultSet result, int rowNum) throws SQLException {
        ShiftType shiftType = new ShiftType();
        shiftType.setId(UUID.fromString(result.getString("id")));
        shiftType.setName(result.getString("name"));
        shiftType.setDescription(result.getString("description"));
        shiftType.setActive(result.getBoolean("active"));
        shiftType.setCreatedAt(result.getTimestamp("createdAt"));
        shiftType.setCreatedBy(result.getString("createdBy"));
        shiftType.setUpdatedBy(result.getString("updatedBy"));
        shiftType.setUpdatedAt(result.getTimestamp("updatedAt"));
        shiftType.setTimeZone(result.getString("timeZone"));
        shiftType.setTenantId(UUID.fromString(result.getString("tenantId")));

        return shiftType;
    }
}
