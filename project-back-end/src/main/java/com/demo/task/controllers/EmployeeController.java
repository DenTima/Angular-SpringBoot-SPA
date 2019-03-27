package com.demo.task.controllers;

import com.demo.task.dto.EmployeeDTO;

import com.demo.task.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO>  getEmployees() {
        List<EmployeeDTO> employeeList;
        employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/page/{pageid}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getEmployeesPage(@PathVariable int pageid){
        int total =5;
        if (pageid==1){
        } else {
            pageid=(pageid-1)*total+1;
        }
        List<EmployeeDTO> employeeList;
        employeeList = employeeService.getEmployeesPagination(pageid, total);
        return employeeList;
    }

    @GetMapping("/employees/{empID}")
    public EmployeeDTO getEmployeesByID(@PathVariable("empID") int empID) {
        return employeeService.findById(empID);
    }

    @PostMapping(value = "/employees/create")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }

    @PutMapping("/employees/{empID}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployee(@PathVariable("empID") int empID, @RequestBody EmployeeDTO employeeUpdate) {
        employeeService.update(empID, employeeUpdate);
        return employeeUpdate;
    }

    @DeleteMapping("/employees/{empID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int empID) {
        employeeService.delete(empID);
    }

    @GetMapping(value = "employees/name/{empName}")
    public List<EmployeeDTO> getEmployeesByName(@PathVariable String empName) {
        List<EmployeeDTO> employees = employeeService.findByName(empName);
        return employees;
    }

}
