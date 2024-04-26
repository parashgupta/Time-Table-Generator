import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponent } from './course/course.component';
import { HomeComponent } from './home/home.component';
import { DownloadComponent } from './download/download.component';
import { LoginPageComponent } from './login-page/login-page.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'course-semester', component: CourseComponent },
  { path: 'download', component: DownloadComponent },
  { path: 'login', component: LoginPageComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
