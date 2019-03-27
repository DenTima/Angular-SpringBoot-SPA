package com.demo.task.dao;

import com.demo.task.entity.Employee;
import com.demo.task.helpers.CustomEmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private JdbcTemplate template;

    @Autowired
    private CustomEmployeeRowMapper employeeRowMapper;

    @Autowired
    public void setTemplate (JdbcTemplate jdbcTemaplate){
        this.template=jdbcTemaplate;
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO tbl_employees(emp_active, emp_name, depid)"
                + "VALUES(?,?,?)";
        template.update(sql, employee.isEmpActive(),
                employee.getEmpName(),
                employee.getEmpDepartment().getDepID());
    }

    @Override
    public Employee findById(int id) {
        String query = "SELECT empid, emp_active, emp_name, depid, dep_name FROM tbl_employees INNER JOIN tbl_departments USING (depid) WHERE tbl_employees.empid = ?";
        return (Employee) template.queryForObject(query, new CustomEmployeeRowMapper(), id);
    }


    @Override
    public void update(Employee employee) {
        String query = "UPDATE tbl_employees SET "
                + "emp_active = ?,"
                + "emp_name = ?,"
                + "depid = ? "
                + "WHERE empid = ?";

        template.update(query, employee.isEmpActive(),
                employee.getEmpName(),
                employee.getEmpDepartment().getDepID(),
                employee.getEmpID());
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM tbl_employees WHERE empid = ?";
        template.update(query, id);
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT empid, emp_active, emp_name, depid, dep_name FROM tbl_employees INNER JOIN tbl_departments USING (depid)";
        return template.query(query, employeeRowMapper);
    }


    @Override
    public List<Employee> findByNameStartsWith(String name) {
        String query = "SELECT empid, emp_active, emp_name, depid, dep_name FROM tbl_employees INNER JOIN tbl_departments USING (depid) WHERE tbl_employees.emp_name LIKE ?";
        return template.query(query, new Object[]{name + "%"}, new CustomEmployeeRowMapper());
    }

    @Override
    public List<Employee> findEmployeePagination(int pageid, int total) {
        String query = "SELECT empid, emp_active, emp_name, depid, dep_name FROM tbl_employees INNER JOIN tbl_departments USING (depid) limit " + (pageid-1) + "," + total;
        return template.query(query, employeeRowMapper);
    }
}
