import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { DepartmentsService } from '../departments.service';
import { Departments } from '../departments';
import { Router } from '@angular/router';

@Component({
  selector: 'departments-list',
  templateUrl: './departments-list.container.html',
  styleUrls: ['./departments-list.container.scss']
})
export class DepartmentsListContainer implements OnInit {
  departments: Observable<Departments[]>;

  constructor(
    private departmentservice: DepartmentsService,
    private router: Router
  ) {}

  ngOnInit() {
    this.reloadData();
  }

  viewDepartment(empID) {
    this.router.navigate([`department-details/${empID}`])
  }

  deleteDepartment(empID) {
    this.departmentservice.deleteDepartment(empID)
      .subscribe(
        data => {
          this.reloadData();
        },
        error => console.log(error));
  }

  reloadData() {
    this.departments = this.departmentservice.getDepartments();
  }
}
