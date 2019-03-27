package com.demo.task.dao;

import com.demo.task.entity.Employee;
import com.demo.task.helpers.BasicDataCrud;

import java.util.List;

public interface EmployeeRepository extends BasicDataCrud<Employee> {
    List<Employee> findEmployeePagination(int pageid, int total);
}
