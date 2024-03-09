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
  selectedSection: string = '';
  selectedFaculty: string[] = [];
  isFormValid: boolean = false;
  subjects: string[] = [];
  faculty: string[] = [];

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/course");
    response.subscribe((data) => this.courses = data);
  }
  
  onSubmit(): void {
    if(this.selectedSection!=='')
    {
      let response = this.semesterService.insertSectionName(this.selectedCourse, this.selectedSemester, this.selectedSection)
      .subscribe(
          (response) => {
              console.log('Response:', response);
          },
          (error) => {
              console.error('Error:', error);
          }
      );
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

  onSemesterChange(): void {
    this.isFormValid = this.selectedCourse !== '' && this.selectedSemester !== '';
    if (this.isFormValid) {
    this.additionalInfoDisplay = 'block';
    this.semesterService.getSubjects(this.selectedCourse, this.selectedSemester).subscribe(
      (subjects: string[]) => {
        this.subjects = subjects;
        // console.log('Subjects:', this.subjects); // Log subjects to the console
      },
      (error) => {
        console.error('Error fetching subjects:', error);
      }
    );
    }
  }

  onChangeSearch(facultyName: string) {
    this.semesterService.getFaculty(facultyName).subscribe(
      (data: string[]) => {
        this.faculty = data;
        // console.log('faculty:', this.faculty); // Log Faculty to the console
      },
      (error) => {
        console.error('Error fetching faculty:', error);
      }
    );
  }

  onFacultySelected(faculty: string, index: number) {
    this.selectedFaculty[index] = faculty;
  }
}