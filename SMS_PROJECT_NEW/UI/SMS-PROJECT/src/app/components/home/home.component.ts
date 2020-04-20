import { Component, OnInit } from '@angular/core';
import { CourseserviceService } from 'src/app/courseservice.service';
import { Router, ActivatedRoute } from '@angular/router';
import { StudentsService } from 'src/app/students.service';
import { TeacherserviceService } from 'src/app/teacherservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  tableDataCourse : any;
  tableDataStudents : any;
  tableDataTeachers : any;

  constructor(private courseserviceService:CourseserviceService,
    private studentsService:StudentsService,
    private teacherserviceService:TeacherserviceService,
    private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.courseserviceService.getCourseList()
   .subscribe(
     response=>{
       console.log(response);
       this.tableDataCourse = Object.keys(response).length;
       console.log(this.tableDataCourse);
     },
     error=>{
       console.log(error);
     }
   )

   this.studentsService.getStudentsList()
     .subscribe(
       response=>{
         console.log(response);
         this.tableDataStudents = Object.keys(response).length;
         console.log(this.tableDataStudents);
       },
       error=>{
         console.log(error);
       }
     )

     this.teacherserviceService.getTeacherList()
     .subscribe(
       response=>{
         console.log(response);
         this.tableDataTeachers = Object.keys(response).length;
         console.log(this.tableDataTeachers);
       },
       error=>{
         console.log(error);
       }
     )
    }

}
