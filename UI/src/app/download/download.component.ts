import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SemesterService } from '../semester.service';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {

  constructor(private http: HttpClient, private semesterService: SemesterService) {}

  courses: any;
  semesters: string[] = [];
  selectedCourse: string = '';
  selectedSemester: string = '';
  isFormValid: boolean = false;
  additionalInfoDisplay: string = 'none';
  subjects: string[] = [];

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/course");
    response.subscribe((data) => this.courses = data);
  }

  onCourseChange(): void {
    if (this.selectedCourse) {
      this.semesterService.getSemesters(this.selectedCourse).subscribe(
        (data) => {
          this.semesters = data;
        },
        (error) => {
          console.error('Error fetching semesters:', error);
        }
      );
    }
    this.isFormValid = this.selectedCourse !== '' && this.selectedSemester !== '';
  }

  onSemesterChange(): void {
    this.isFormValid = this.selectedCourse !== '' && this.selectedSemester !== '';
    if (this.isFormValid) {
    this.semesterService.getSubjects(this.selectedCourse, this.selectedSemester).subscribe(
      (subjects: string[]) => {
        this.subjects = subjects;
        // console.log('Subjects:', this.subjects); // Log subjects to the console
        // console.log("Inside onSemesterChange method");
      },
      (error) => {
        console.error('Error fetching subjects:', error);
      }
    );
    }
  }

}
