import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './components/students/students.component';
import { CourseComponent } from './components/course/course.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { HomeComponent } from './components/home/home.component';
import { AddcoursesComponent } from './components/addcourses/addcourses.component';
import { AddstudentsComponent } from './components/addstudents/addstudents.component';
import { AddteacherComponent } from './components/addteacher/addteacher.component';
import { UpdatestudentsComponent } from './components/updatestudents/updatestudents.component';
import { SearchstudentsComponent } from './components/searchstudents/searchstudents.component';
import { LoginComponent } from './components/login/login.component';
import { UpdateTeachersComponent } from './components/update-teachers/update-teachers.component';
import { UpdatecourseComponent } from './components/updatecourse/updatecourse.component';
import { TeachercourseComponent } from './components/teachercourse/teachercourse.component';
import { StudentcourseComponent } from './components/studentcourse/studentcourse.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGaurdService } from './auth-gaurd.service';
import { ProfileComponent } from './components/profile/profile.component';




const routes: Routes = [
{ path: 'students', component: StudentsComponent,canActivate:[AuthGaurdService] },
// { path: 'login', component: LoginComponent },
{ path: '', component: LoginComponent },
{ path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
{ path: 'course', component: CourseComponent, canActivate:[AuthGaurdService] },
{ path: 'teacher', component: TeacherComponent,canActivate:[AuthGaurdService] },
{ path: 'home', component: HomeComponent ,canActivate:[AuthGaurdService]},
{ path: 'addstudents', component: AddstudentsComponent ,canActivate:[AuthGaurdService]},
{ path: 'addcourses', component: AddcoursesComponent,canActivate:[AuthGaurdService] },

{path:'updatestudents/:id', component:UpdatestudentsComponent,canActivate:[AuthGaurdService]},
{path:'update-teachers/:id', component:UpdateTeachersComponent,canActivate:[AuthGaurdService]},

{path:'updatecourse/:id', component:UpdatecourseComponent,canActivate:[AuthGaurdService]},
{path:'profile/:id', component:ProfileComponent,canActivate:[AuthGaurdService]},
{path:'Studentcourse/:id', component:StudentcourseComponent,canActivate:[AuthGaurdService]},
{path:'Teachercourse/:id', component:TeachercourseComponent,canActivate:[AuthGaurdService]},

{path:'searchstudents/:id', component:SearchstudentsComponent,canActivate:[AuthGaurdService]},

{ path: 'addteacher', component: AddteacherComponent,canActivate:[AuthGaurdService] }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
