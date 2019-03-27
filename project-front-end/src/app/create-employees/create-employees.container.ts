import { Component, OnInit } from '@angular/core';

import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DepartmentsService } from '../departments.service';
import { Departments } from '../departments';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employees.container.html',
})
export class CreateEmployeesContainer implements OnInit {
  submitted = false;
  form = new FormGroup({
    empName: new FormControl('', Validators.required),
    empActive: new FormControl(true),
    empDepartment: new FormControl('', Validators.required)
  });
  departments: Departments[] = [];

  constructor(
    private employeeService: EmployeesService,
    private departmentService: DepartmentsService,
    private router: Router
    ) { }

  ngOnInit() {
    this.departmentService.getDepartments().subscribe(departments => {
      this.departments = departments;
    })
  }

  newEmployee(): void {
    this.submitted = false;
    this.form.reset()
  }

  save() {
    this.employeeService.createEmployee(this.form.value)
      .subscribe(data => {
        this.submitted = true;
      });
  }

  cancel() {
    this.router.navigate(['employees'])
  }
}
