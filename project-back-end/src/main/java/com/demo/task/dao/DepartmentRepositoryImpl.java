package com.demo.task.dao;

import com.demo.task.entity.Department;
import com.demo.task.helpers.CustomDepartmentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentRepository")
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private JdbcTemplate template;

    @Autowired
    private CustomDepartmentRowMapper rowMapper;

    @Autowired
    public void setTemplate (JdbcTemplate jdbcTemplate){
        this.template=jdbcTemplate;
    }


    @Override
    public void save(Department department) {
        String sql = "INSERT INTO tbl_departments(dep_name) "
                + "VALUES(?)";
        template.update(sql, department.getDepName());
    }

    @Override
    public Department findById(int id) {
        String query = "SELECT depid,dep_name FROM tbl_departments WHERE depid = ?";
        return (Department) template.queryForObject(query, new CustomDepartmentRowMapper(), id);
    }

    @Override
    public List<Department> findAll() {
        String query = "SELECT depid, dep_name FROM tbl_departments";
        return template.query(query, rowMapper);
    }
}
