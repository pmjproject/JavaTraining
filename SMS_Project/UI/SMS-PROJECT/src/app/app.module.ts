import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { StudentsComponent } from './components/students/students.component';
// import { CourseComponent } from './components/course/course.component';

import { RouterModule, Routes } from '@angular/router';
import { TeacherComponent } from './components/teacher/teacher.component';
import { CourseComponent } from './components/course/course.component';
import { AddstudentsComponent } from './components/addstudents/addstudents.component';
import { AddcoursesComponent } from './components/addcourses/addcourses.component';
import { AddteacherComponent } from './components/addteacher/addteacher.component';



const appRoutes: Routes = [
  { path: 'students', component: StudentsComponent },
  { path: 'course', component: CourseComponent },
  { path: 'teacher', component: TeacherComponent },
  { path: 'home', component: HomeComponent },
  { path: 'addstudents', component: AddstudentsComponent },
  { path: 'addcourses', component: AddcoursesComponent },
  { path: 'addteacher', component: AddteacherComponent }
  
  
  

];
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    StudentsComponent,
    TeacherComponent,
    CourseComponent,
    AddstudentsComponent,
    AddcoursesComponent,
    AddteacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
