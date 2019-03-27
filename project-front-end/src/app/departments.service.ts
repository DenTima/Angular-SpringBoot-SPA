import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService {

  private baseUrl = 'http://localhost:8080/api/departments';

  constructor(private http: HttpClient) { }

  createDepartment(department: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/create`, department);
  }

  getDepartments(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteDepartment(depID: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${depID}`);
  }
}
