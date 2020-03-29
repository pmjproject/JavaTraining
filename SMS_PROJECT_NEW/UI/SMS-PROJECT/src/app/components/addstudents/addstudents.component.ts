import { Component, OnInit } from '@angular/core';

import { StudentsService } from '../../students.service';
import { Router } from '@angular/router';
// import { Students } from '../../students';


@Component({
  selector: 'app-addstudents',
  templateUrl: './addstudents.component.html',
  styleUrls: ['./addstudents.component.scss']
})
export class AddstudentsComponent implements OnInit {
 
  firstName: string;
  lastName: string;
  email: string;
   age: string;
  dob: string;
   courseId: string;
   active: string;
   city:string;
   address:string;	
   number: string;

   data:any[];
  // students: Students = new Students();
  // submitted = false;

  constructor(private studentsService:StudentsService) { }
  

  ngOnInit(){
    // this.addstudents = new Addstudents(0,"", "", "", 0, "", 0, false,"","","");
  }
  // newStudent(): void {
  //   this.submitted = false;
  //   this.students = new Students();
  // }
  // saveStudent(): void{
  //   console.log(this.addstudents);
  //   this.addstudentsService.saveStudent(this.addstudents).subscribe(addstudents => this.addstudents = addstudents);
  //   // console.log("Saved Successfully");
    
  // }

  save() {
    var students ={
    
    "firstName": this.firstName,
    "lastName": this.lastName,
    "email": this.email,
    "age": this.age,
    "dob":this.dob,
    "courseId": this.courseId,
    "active": this.active,
    
    "address": {
      "city":this.city,
      "address": this.address
      
    },
    "telephones": [
      {"number":this.number}
     
    ]

    };
    this.studentsService.Addstudents(students).subscribe(
      (data: any[]) => this.data = data,
      // (alert) => ("gfgfgg")

      (error) => console.log("error")
      );
     
  }

 

}
