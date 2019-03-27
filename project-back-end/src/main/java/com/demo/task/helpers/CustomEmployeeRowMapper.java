package com.demo.task.helpers;

import com.demo.task.entity.Department;
import com.demo.task.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomEmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpID(rs.getInt("empid"));
        employee.setEmpActive(rs.getBoolean("emp_active"));
        employee.setEmpName(rs.getString("emp_name"));
        Department department = new Department();
        department.setDepID(rs.getInt("depid"));
        department.setDepName(rs.getString("dep_name"));
        employee.setEmpDepartment(department);
        return employee;
    }
}
