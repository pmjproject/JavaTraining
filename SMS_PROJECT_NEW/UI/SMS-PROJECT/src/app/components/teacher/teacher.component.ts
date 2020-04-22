import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherserviceService } from 'src/app/teacherservice.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.scss']
})
export class TeacherComponent implements OnInit {
  tableData : any;
  filter;
  p: number = 1;

  constructor(private teacherserviceService:TeacherserviceService,
   private router:Router,private route: ActivatedRoute) {
 
  }

  details(data) {
    console.log(data)
 
   let id = data.id
 
  
   this.router.navigate(['/update-teachers', id]);

  }


  searchData(id) {
    console.log(id)
 
  
   this.router.navigate(['/searchstudents', id]);

  }

   ngOnInit() {
   
    this.reloadData();

   }
   reloadData() {
      this.teacherserviceService.getTeacherList()
     .subscribe(
       response=>{
         console.log("qqqqqqqqqqqqqqqqqqqqqqqqqq",response);
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
  

  deleteTeacher(data) {
    this.teacherserviceService.deleteTeacher(data)
      .subscribe(
        data => {
          console.log(data);
          
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
 
 }

