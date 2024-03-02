// src/app/services/semester.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SemesterService {
  private baseUrl = 'http://localhost:8080/course/courseName';

  constructor(private http: HttpClient) {}

  getSemesters(courseName: string): Observable<any> {
    const url = `${this.baseUrl}?courseName=${courseName}`;
    return this.http.get(url);
  }

  getSubjects(selectedCourse: String,selectedSemester: String)
  {
    const url = `http://localhost:8080/course/subject?courseName=${selectedCourse}&semester=${selectedSemester}`;
    return this.http.get<string[]>(url);
  }

  getFaculty(facultyName: String)
  {
    const url = `http://localhost:8080/course/name?name=${facultyName}`;
    return this.http.get<string[]>(url);
  }
}
