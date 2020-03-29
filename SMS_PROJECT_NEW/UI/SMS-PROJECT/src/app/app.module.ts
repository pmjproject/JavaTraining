import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule} from '@angular/forms' 
import { HttpClientModule } from '@angular/common/http';
// import { from } from 'rxjs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { StudentsComponent } from './components/students/students.component';
import { RouterModule, Routes } from '@angular/router';
import { TeacherComponent } from './components/teacher/teacher.component';
import { CourseComponent } from './components/course/course.component';
import { AddstudentsComponent } from './components/addstudents/addstudents.component';
import { AddcoursesComponent } from './components/addcourses/addcourses.component';
import { AddteacherComponent } from './components/addteacher/addteacher.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { UpdatestudentsComponent } from './components/updatestudents/updatestudents.component';
import { SearchstudentsComponent } from './components/searchstudents/searchstudents.component';





const appRoutes: Routes = [
  
  
  
  

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
    AddcoursesComponent,
    AddteacherComponent,
    HeaderComponent,
    LoginComponent,
    AddstudentsComponent,
    UpdatestudentsComponent,
    SearchstudentsComponent,
    
    

 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
