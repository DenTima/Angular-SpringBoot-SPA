import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateEmployeesContainer } from './create-employees/create-employees.container';
import { CreateDepartmentsContainer } from './create-departments/create-departments.container';
import { EmployeesDetailsContainer } from './employees-details/employees-details.container';
import { EmployeesListContainer } from './employees-list/employees-list.container';
import { DepartmentsDetailsContainer } from './departments-details/departments-details.container';
import { DepartmentsListContainer } from './departments-list/departments-list.container';
import { SearchEmployeesContainer } from './search-employees/search-employees.container';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatMenuModule,
  MatButtonModule,
  MatListModule,
  MatCheckboxModule,
  MatToolbarModule,
  MatIconModule,
  MatInputModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatPaginatorModule, MatSelectModule, MatSortModule
} from '@angular/material';
import {EmployeesTableComponent} from "./employees-list/employees-table/employees-table.component";
import {DepartmentsTableComponent} from "./departments-list/departments-table/departments-table.component";
import { Http, HttpModule } from '@angular/http';
import { AuthHttp, AuthConfig } from 'angular2-jwt';
import { TOKEN_NAME } from './services/auth.constant';
import { LoginComponent } from './login/login.component';
import { AdminAuthGuard } from './guards/admin-auth-guard.service';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AuthenticationService } from './services/authentication.service';
import { UserService } from './services/user.service';
import { AuthGuard } from './guards/auth-guard.service';
import { AppDataService } from './services/app-data.service';
import { EmployeesService } from './employees.service';

export function authHttpServiceFactory(http: Http) {
  return new AuthHttp(new AuthConfig({
    headerPrefix: 'Bearer',
    tokenName: TOKEN_NAME,
    globalHeaders: [{'Content-Type': 'application/json'}],
    noJwtError: false,
    noTokenScheme: true,
    tokenGetter: (() => localStorage.getItem(TOKEN_NAME))
  }), http);
}

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeesContainer,
    CreateDepartmentsContainer,
    EmployeesDetailsContainer,
    EmployeesListContainer,
    DepartmentsDetailsContainer,
    DepartmentsListContainer,
    SearchEmployeesContainer,
    EmployeesTableComponent,
    DepartmentsTableComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatListModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatTableModule,
    MatPaginatorModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSortModule,
    AppRoutingModule,
    HttpModule,
  ],
  providers: [{provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http]},
  AuthenticationService,
  UserService,
  AuthGuard,
  AdminAuthGuard,
  AppDataService,
  EmployeesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
