import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {

  tableData : any;
  Course : any;
  filter;
  p: number = 1;

  constructor(private courseserviceService:CourseserviceService,
   private router:Router,private route: ActivatedRoute) {
 
  }

  details(data) {
    console.log(data)
 
   let id = data.id
 
  
   this.router.navigate(['/updatecourse', id]);

  }
  detailsTeachers(data) {
    console.log(data)
 
   let id = data.course_name
 
  
   this.router.navigate(['/Teachercourse', id]);

  }
  detailsStudents(data) {
    console.log(data)
 
   let id = data.course_name
 
  
   this.router.navigate(['/Studentcourse', id]);

  }

  

  // searchData(id) {
  //   console.log(id)
 
  
  //  this.router.navigate(['/searchstudents', id]);

  // }

   ngOnInit() {
   
    this.reloadData();

   }
   reloadData() {
      this.courseserviceService.getCourseList()
     .subscribe(
       response=>{
         console.log(response);
         this.tableData = response;
       },
       error=>{
         console.log(error);
       }
     )

     this.courseserviceService.getCourseList()
   .subscribe(
     response=>{
       console.log(response);
       this.Course = response;
     },
     error=>{
       console.log(error);
     }
   )

  }

//   searchData(id) {
//     this.studentsService.getStudent(id)
//    .subscribe(
//      response=>{
//        console.log(response);
//        this.tableData = response;
//      },
//      error=>{
//        console.log(error);
//      }
//    )
// }
  

  deleteCourse(data) {
    this.courseserviceService.deleteCourse(data)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
  }
 
 }

