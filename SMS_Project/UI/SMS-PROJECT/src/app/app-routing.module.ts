import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './components/students/students.component';
import { CourseComponent } from './components/course/course.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { HomeComponent } from './components/home/home.component';
import { AddcoursesComponent } from './components/addcourses/addcourses.component';
import { AddstudentsComponent } from './components/addstudents/addstudents.component';
import { AddteacherComponent } from './components/addteacher/addteacher.component';


const routes: Routes = [
{ path: 'students', component: StudentsComponent },
{ path: 'course', component: CourseComponent },
{ path: 'teacher', component: TeacherComponent },
{ path: 'home', component: HomeComponent },
{ path: 'addstudents', component: AddstudentsComponent },
{ path: 'addcourses', component: AddcoursesComponent },
{ path: 'addteacher', component: AddteacherComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
