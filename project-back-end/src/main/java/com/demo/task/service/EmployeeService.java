package com.demo.task.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.task.dao.DepartmentRepository;
import com.demo.task.dto.DepartmentDTO;
import com.demo.task.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.demo.task.dao.EmployeeRepository;

import com.demo.task.dto.EmployeeDTO;

import com.demo.task.entity.Employee;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeDTOList.add(convertToDTO(employee));
        }

        return employeeDTOList;
    }

    public List<EmployeeDTO> getEmployeesPagination(int pageid, int total) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findEmployeePagination(pageid, total)) {
            employeeDTOList.add(convertToDTO(employee));
        }

        return employeeDTOList;
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpActive(employeeDTO.getEmpActive());

        DepartmentDTO departmentDTO = employeeDTO.getEmpDepartment();
        Department departmentDB = departmentRepository.findById(departmentDTO.getDepID());
        employee.setEmpDepartment(departmentDB);

        employeeRepository.save(employee);
        return employeeDTO;
    }


    public void update(int empID, EmployeeDTO employeeUpdate) {

        Employee employeeDB = employeeRepository.findById(empID);
        employeeDB.setEmpName(employeeUpdate.getEmpName());
        employeeDB.setEmpActive(employeeUpdate.getEmpActive());

        DepartmentDTO departmentDTO = employeeUpdate.getEmpDepartment();
        Department departmentDB = departmentRepository.findById(departmentDTO.getDepID());
        employeeDB.setEmpDepartment(departmentDB);

        employeeRepository.update(employeeDB);
    }

    public void delete(int empID) {
        employeeRepository.delete(empID);
    }

    private EmployeeDTO convertToDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        DepartmentDTO departmentDTO = new DepartmentDTO();

        employeeDTO.setEmpID(employee.getEmpID());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setEmpActive(employee.isEmpActive());

        departmentDTO.setDepID(employee.getEmpDepartment().getDepID());
        departmentDTO.setDepName(employee.getEmpDepartment().getDepName());
        employeeDTO.setEmpDepartment(departmentDTO);

        return employeeDTO;
    }

    public EmployeeDTO findById(int id) {
        return convertToDTO(employeeRepository.findById(id));
    }

    public List<EmployeeDTO> findByName(String name) {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findByNameStartsWith(name)) {
            employeeDTOList.add(convertToDTO(employee));
        }

        return employeeDTOList;
    }

}
