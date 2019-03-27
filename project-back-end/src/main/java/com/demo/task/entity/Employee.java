package com.demo.task.entity;

public class Employee {
    private Integer empID;
    private Boolean empActive;
    private String empName;
    private Department empDepartment;

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public Boolean isEmpActive() {
        return empActive;
    }

    public void setEmpActive(Boolean empActive) {
        this.empActive = empActive;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(Department empDepartment) {
        this.empDepartment = empDepartment;
    }
}
