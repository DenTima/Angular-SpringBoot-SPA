import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  private baseUrl = '/api/employees';

  constructor(private http: HttpClient) { }

  getEmployeesByID(empID: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${empID}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    console.log(employee,'fuck');
    return this.http.post(`${this.baseUrl}/create`, employee);
  }

  updateEmployee(empID: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${empID}`, value);
  }

  deleteEmployee(empID: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${empID}`);
  }

  getEmployees(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getEmployeesByName(empName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${empName}`);
  }

}
