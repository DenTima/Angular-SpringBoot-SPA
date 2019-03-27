import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesListContainer } from './employees-list/employees-list.container';
import { DepartmentsListContainer } from './departments-list/departments-list.container';
import { CreateEmployeesContainer } from './create-employees/create-employees.container';
import { CreateDepartmentsContainer } from './create-departments/create-departments.container';
import { SearchEmployeesContainer } from './search-employees/search-employees.container';
import { EmployeesDetailsContainer } from './employees-details/employees-details.container';
import { DepartmentsDetailsContainer } from './departments-details/departments-details.container';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './guards/auth-guard.service';
import { AdminAuthGuard } from './guards/admin-auth-guard.service';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: 'home',
    component: HomeComponent
  },
  { path: 'employees', component: EmployeesListContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'employees/add', component: CreateEmployeesContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'employee-details/:empID', component: EmployeesDetailsContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'departments', component: DepartmentsListContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'departments/add', component: CreateDepartmentsContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'departments/:empID', component: DepartmentsDetailsContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  { path: 'findbyname', component: SearchEmployeesContainer, canActivate: [AuthGuard, AdminAuthGuard] },
  {path: '**', redirectTo: '/home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
