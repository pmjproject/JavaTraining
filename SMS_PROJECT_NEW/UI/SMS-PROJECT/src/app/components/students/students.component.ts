import { Component, OnInit } from '@angular/core';

// import { Observable } from 'rxjs';
import { StudentsService } from 'src/app/students.service';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent implements OnInit {

  tableData : any;
  filter;
  p: number = 1;

  constructor(private studentsService:StudentsService,
   private router:Router,private route: ActivatedRoute) {
 
  }

  details(data) {
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
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {
        this.studentsService.deleteStudent(data)
      .subscribe(
        data => {
          console.log(data);
          
          this.reloadData();
        },
        error => console.log(error));
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Deleted',
          showConfirmButton: true,
          timer: 5500
        })
        this.reloadData();
      }
    })
    
  }
 
 }

