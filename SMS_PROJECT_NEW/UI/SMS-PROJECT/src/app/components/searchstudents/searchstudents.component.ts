import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentsService } from 'src/app/students.service';

@Component({
  selector: 'app-searchstudents',
  templateUrl: './searchstudents.component.html',
  styleUrls: ['./searchstudents.component.scss']
})
export class SearchstudentsComponent implements OnInit {

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

  // searchData(id) {
  //   console.log(id)
 
  
  //  this.router.navigate(['/searchstudents', id]);

  // }

   ngOnInit() {
   
    // this.reloadData();

   }
  //  reloadData() {
  //     this.studentsService.getStudentsList()
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

  searchData(id) {
    this.studentsService.getStudent(id)
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
  

  deleteStudent(data) {
    this.studentsService.deleteStudent(data)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
  }
 
 }

