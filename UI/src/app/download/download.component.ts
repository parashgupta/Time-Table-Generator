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
  selectedSection: string = '';
  isFormValid: boolean = false;
  additionalInfoDisplay: string = 'none';
  subjects: string[] = [];
  sections: any;
  sectionvalue: boolean = false;

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/course");
    response.subscribe((data) => this.courses = data);
  }

  onCourseChange(): void {
    if (this.selectedCourse) {
      this.additionalInfoDisplay = 'none';
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
    this.additionalInfoDisplay = 'none';
    if (this.isFormValid) {
    this.semesterService.checkSection(this.selectedCourse, this.selectedSemester).subscribe(
      (data) => {
        this.sectionvalue = data;
        console.log(this.sectionvalue);
        if (this.sectionvalue) {
          // If section is true, fetch all sections
          this.additionalInfoDisplay = 'block';
          this.semesterService.allsection().subscribe(
            (sectiondata) => {
              this.sections = sectiondata;
              console.log(this.sections);
            },
            (error) => {
              console.error('Error fetching all sections:', error);
            }
          );
        }
      },
      (error) => {
        console.error('Error fetching checksection:', error);
      }
    );
    }
  }

  onSectionChange(): void {
    // this.isFormValid = this.selectedCourse !== '' && this.selectedSemester !== '';


    
  }


}
