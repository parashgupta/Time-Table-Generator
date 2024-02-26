import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SemesterService } from '../semester.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  constructor(private http: HttpClient, private semesterService: SemesterService) {}

  courses: any;
  semesters: string[] = [];
  additionalInfoDisplay: string = 'none';
  selectedCourse: string = '';
  selectedSemester: string = '';
  isFormValid: boolean = false;

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/course");
    response.subscribe((data) => this.courses = data);
  }
  
  onSubmit(form: NgForm) {
    if (this.isFormValid) {
    this.additionalInfoDisplay = 'block';
    }
  }

  toggleInputField() {
    const inputField = document.getElementById("inputField") as HTMLInputElement;
    const sectionSelect = document.getElementById("section") as HTMLSelectElement;
    inputField.style.display = (sectionSelect.value === "yes") ? "block" : "none";
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

  
}