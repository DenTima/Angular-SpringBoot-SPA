package com.demo.task.service;

import com.demo.task.dao.DepartmentRepository;
import com.demo.task.dto.DepartmentDTO;
import com.demo.task.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getDepartments() {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepID(department.getDepID());
            departmentDTO.setDepName(department.getDepName());

            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

    public DepartmentDTO create(DepartmentDTO departmentDTO) {

        Department department = new Department();
        department.setDepName(departmentDTO.getDepName());
        departmentRepository.save(department);

        return departmentDTO;
    }
}
