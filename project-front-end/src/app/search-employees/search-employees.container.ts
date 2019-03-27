import { Component, OnInit } from '@angular/core';
import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import {Observable} from "rxjs/index";

@Component({
  selector: 'search-employees',
  templateUrl: './search-employees.container.html',

})
export class SearchEmployeesContainer implements OnInit {
  employees: Observable<Employees[]>;
  form = new FormGroup({
    empName: new FormControl('', Validators.required),
  });

  constructor(
    private dataService: EmployeesService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  viewEmployee(empID) {
    this.router.navigate([`employee/${empID}`])
  }

  deleteEmployee(empID) {
    this.dataService.deleteEmployee(empID)
      .subscribe(
        data => {
          this.employees = data;
          this.searchEmployees();
        },
        error => console.log(error));
  }

  searchEmployees() {
    this.dataService.getEmployeesByName(this.form.value.empName)
      .subscribe(employees => this.employees = employees);
  }

  save() {
    this.searchEmployees()
  }
  cancel() {
    this.router.navigate(['employees'])
  }

  onSubmit() {
    this.searchEmployees();
  }


}
