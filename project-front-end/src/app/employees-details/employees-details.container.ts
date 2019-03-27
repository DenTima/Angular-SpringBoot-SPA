import { Component, OnInit, Input } from '@angular/core';
import { EmployeesService } from '../employees.service';
import { Employees } from '../employees';

import { EmployeesListContainer } from '../employees-list/employees-list.container';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'employee-details',
  templateUrl: './employees-details.container.html',
})
export class EmployeesDetailsContainer implements OnInit {
  empID;
  isSubmitButtonActive = true;
  form = new FormGroup({
    empName: new FormControl('', Validators.required),
    empActive: new FormControl('true', Validators.required),
    empDepartment: new FormControl('', Validators.required)
  });

  constructor(
    private employeeService: EmployeesService,
    private $router: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.$router.params.subscribe(params => {
      this.employeeService.getEmployeesByID(params['empID']).subscribe((item: Employees) => {
        this.empID = params['empID'];
        this.form.patchValue({ ...item });
      })
    })
  }

  save() {
    this.isSubmitButtonActive = false;
    this.updateActive();
  }

  cancel() {
    this.router.navigate(['employees'])
  }

  updateActive() {
    this.employeeService.updateEmployee(this.empID, this.form.value)
      .subscribe(
        data => {
          console.log(data);
          this.isSubmitButtonActive = true;
          this.cancel();
        })
  }
}
