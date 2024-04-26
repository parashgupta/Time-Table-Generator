import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SemesterService } from '../semester.service';
import { NgForm } from '@angular/forms';
import { forkJoin } from 'rxjs';



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
  facultylist: string[] = [];

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/course");
    response.subscribe((data) => this.courses = data);
  }
  
  onSubmit(): void {
    console.log('Submit button clicked');
  
    const requests = [];
  
    if (this.selectedSection !== '') {
      console.log('Inserting section name:', this.selectedSection);
      requests.push(
        this.semesterService.insertSectionName(this.selectedCourse, this.selectedSemester, this.selectedSection)
      );
    }
    
    const dataMap = new Map<string, string>();
    this.subjects.forEach((subject, index) => {
        dataMap.set(subject, this.selectedFaculty[index]);
    });
    console.log(dataMap);

    requests.push(
      this.semesterService.allotFaculty(this.selectedCourse, this.selectedSemester,this.selectedSection, dataMap)
    );
  
    forkJoin(requests).subscribe(
      (responses) => {
        console.log('All requests completed:', responses);
      },
      (error) => {
        console.error('Error during requests:', error);
      }
    );

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
        this.facultylist = data;
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