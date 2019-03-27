import { Component, OnInit } from '@angular/core';

import { Departments } from '../departments';
import { DepartmentsService } from '../departments.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'create-department',
  templateUrl: './create-departments.container.html',
})
export class CreateDepartmentsContainer implements OnInit {
  submitted = false;
  form = new FormGroup({
    depName: new FormControl('', Validators.required),
  });

  constructor(
    private departmentService: DepartmentsService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  newDepartment(): void {
    this.submitted = false;
    this.form.reset()
  }

  save() {
    this.departmentService.createDepartment(this.form.value)
      .subscribe(data => {
        this.submitted = true;
      });
  }

  cancel() {
    this.router.navigate(['departments'])
  }
}
