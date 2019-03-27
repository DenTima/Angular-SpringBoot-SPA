package com.demo.task.helpers;

import com.demo.task.entity.Department;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomDepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {

        Department department = new Department();
        department.setDepID(rs.getInt("depid"));
        department.setDepName(rs.getString("dep_name"));

        return department;
    }
}
