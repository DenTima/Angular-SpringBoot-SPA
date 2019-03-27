package com.demo.task.entity;

import java.util.List;

public class Department {
    private Integer depID;
    private String depName;
    private List<Employee> employees;

    public Integer getDepID() {
        return depID;
    }

    public void setDepID(final Integer depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(final String depName) {
        this.depName = depName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }
}
