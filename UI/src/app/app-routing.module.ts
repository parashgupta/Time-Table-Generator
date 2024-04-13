import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponent } from './course/course.component';
import { HomeComponent } from './home/home.component';
import { DownloadComponent } from './download/download.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'course-semester', component: CourseComponent },
  { path: 'download', component: DownloadComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
