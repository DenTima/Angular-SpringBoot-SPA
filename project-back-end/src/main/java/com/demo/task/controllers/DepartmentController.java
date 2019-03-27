package com.demo.task.controllers;

import com.demo.task.dto.DepartmentDTO;
import com.demo.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentDTO>  getDepartments() {
        List<DepartmentDTO> departmentList;
        departmentList = departmentService.getDepartments();
        return departmentList;
    }

    @PostMapping(value = "/departments/create")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.create(departmentDTO);
    }
}
