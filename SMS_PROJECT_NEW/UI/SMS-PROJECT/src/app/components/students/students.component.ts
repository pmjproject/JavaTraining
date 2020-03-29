import { Component, OnInit } from '@angular/core';
// import { Students } from 'src/app/students';
// import { Observable } from 'rxjs';
import { StudentsService } from 'src/app/students.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent implements OnInit {

  tableData : any;

  constructor(private studentsService:StudentsService,
   private router:Router,private route: ActivatedRoute) {
 
  }

  updateDetails(data) {
    console.log(data)
 
   let id = data.id
 
  //  this.router.navigate(['/updatestudents', id]);
  //  this.router.navigate(['../updatestudents', id], { relativeTo: this.route });
   this.router.navigate(['/updatestudents', id]);

  }

  searchData(id) {
    console.log(id)
 
  
   this.router.navigate(['/searchstudents', id]);

  }

   ngOnInit() {
   
    this.reloadData();

   }
   reloadData() {
      this.studentsService.getStudentsList()
     .subscribe(
       response=>{
         console.log(response);
         this.tableData = response;
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
  

  deleteStudent(data) {
    this.studentsService.deleteStudent(data)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
  }
 
 }

