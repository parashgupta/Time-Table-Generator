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
  section: boolean = false;

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
    this.additionalInfoDisplay = 'block';
    this.semesterService.checkSection(this.selectedCourse, this.selectedSemester).subscribe(
      (data) => {
        this.section = data;
        console.log(this.section);
      },
      (error) => {
        console.error('Error fetching subjects:', error);
      }
    );
    }
  }

}
