import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { EmployeesService } from '../employees.service';
import { Employees } from '../employees';
import { Router } from '@angular/router';

@Component({
  selector: 'employees-list',
  templateUrl: './employees-list.container.html',
  styleUrls: ['./employees-list.container.scss']
})
export class EmployeesListContainer implements OnInit {
  employees: Observable<Employees[]>;

  constructor(
    private employeeService: EmployeesService,
    private router: Router
  ) {}

  ngOnInit() {
    this.reloadData();
  }

  viewEmployee(empID) {
    this.router.navigate([`employee-details/${empID}`])
  }

  deleteEmployee(empID) {
    this.employeeService.deleteEmployee(empID)
      .subscribe(
        data => {
          this.reloadData();
        },
        error => console.log(error));
  }

  reloadData() {
    this.employees = this.employeeService.getEmployees();
  }
}
