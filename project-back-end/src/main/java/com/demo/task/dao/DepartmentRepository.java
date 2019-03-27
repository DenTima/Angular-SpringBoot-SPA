package com.demo.task.dao;

import com.demo.task.entity.Department;

import java.util.List;


public interface DepartmentRepository {
    List<Department> findAll();
    void save(Department department);
    Department findById(int id);
}
