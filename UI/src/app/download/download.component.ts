import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SemesterService } from '../semester.service';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {
  @ViewChild('buttonElement') buttonElement!: ElementRef;

  constructor(private http: HttpClient, private semesterService: SemesterService) {}

  courses: any;
  semesters: string[] = [];
  selectedCourse: string = '';
  selectedSemester: string = '';
  selectedSection: string = '';
  isFormValid: boolean = false;
  additionalInfoDisplay: string = 'none';
  subjects: string[] = [];
  sections: string[] =[];
  sectionvalue: boolean = false;
  days: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
  timetable: any;
  
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
          this.semesterService.allsection(this.selectedCourse,this.selectedSemester).subscribe(
            (sectiondata) => {
              this.sections = sectiondata;
              console.log(this.sections);
            },
            (error) => {
              console.error('Error fetching all sections:', error);
            }
          );
        }
        else{
          this.semesterService.showtimetable(this.selectedCourse, this.selectedSemester,this.selectedSection).subscribe(
            (data) => {
              this.timetable = data;
              console.log(this.timetable);
              console.log(this.selectedSection);
            },
            (error) => {
              console.error('Error fetching data:', error);
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
    console.log("inside onSectionChange function");
    this.semesterService.showtimetable(this.selectedCourse, this.selectedSemester,this.selectedSection).subscribe(
      (data) => {
        this.timetable = data;
        console.log(this.timetable);
        console.log(this.selectedSection);
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
    console.log("onSectionChange completed");
  }

  animateButton(): void {
    this.semesterService.downloadtimetable(this.selectedCourse, this.selectedSemester,this.selectedSection).subscribe();
    const button = this.buttonElement.nativeElement;
    button.classList.add('onclic');
    setTimeout(() => {
      button.classList.remove('onclic');
      button.classList.add('validate');
      setTimeout(() => {
        button.classList.remove('validate');
      }, 1250);
    }, 2250);
  }



}
