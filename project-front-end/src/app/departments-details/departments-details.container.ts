import { Component, OnInit, Input } from '@angular/core';
import { DepartmentsService } from '../departments.service';

import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'department-details',
  templateUrl: './departments-details.container.html',
})
export class DepartmentsDetailsContainer implements OnInit {
  depID;
  isSubmitButtonActive = true;
  form = new FormGroup({
    depName: new FormControl('', Validators.required),
  });

  constructor(
    private departmentService: DepartmentsService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  save() {
    this.isSubmitButtonActive = false;
    this.departmentService.createDepartment(this.form.value).subscribe(() => {
      this.router.navigate(['departments']);
    });
  }

  cancel() {
    this.router.navigate(['departments']);
  }
}
