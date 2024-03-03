// src/app/services/semester.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SemesterService {
  private baseUrl = 'http://localhost:8080/course';

  constructor(private http: HttpClient) {}

  getSemesters(courseName: string): Observable<any> {
    const url = `${this.baseUrl}/courseName?courseName=${courseName}`;
    return this.http.get(url);
  }

  getSubjects(selectedCourse: string,selectedSemester: string)
  {
    const url = `${this.baseUrl}/subject?courseName=${selectedCourse}&semester=${selectedSemester}`;
    return this.http.get<string[]>(url);
  }

  getFaculty(facultyName: string): Observable<string[]>
  {
    const url = `${this.baseUrl}/name?name=${facultyName}`;
    return this.http.get<string[]>(url);
  }
}
