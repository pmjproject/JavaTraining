import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

import { StudentsService } from '../../students.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CourseserviceService } from 'src/app/courseservice.service';
// import { Students } from '../../students';


@Component({
  selector: 'app-addstudents',
  templateUrl: './addstudents.component.html',
  styleUrls: ['./addstudents.component.scss']
})
export class AddstudentsComponent implements OnInit {

  studentDetailsregistration: FormGroup;
  submitted = false;
  imageUrl: any;


  private data: any[];
  Course : any;

  
  
  

  constructor(private studentsService: StudentsService,
    private formBuilder: FormBuilder,
    private cd: ChangeDetectorRef,
    private courseserviceService:CourseserviceService
  ) {
    this.studentsService = studentsService;
  }

  

    

  ngOnInit() {
    this.studentDetailsregistration = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseId: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      number: ['', Validators.required],
      number2: ['', Validators.required]
      
    })
    this.reloadData();
    // this.getOwners();
    
  }

  reloadData() {
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
  

  
  get controlerData() {
    return this.studentDetailsregistration.controls;
  }


  

  uploadSubmit() {
    this.submitted = true;

    if (this.studentDetailsregistration.valid) {
      let studentData = {
        "firstName": this.controlerData.firstName.value,
        "lastName": this.controlerData.lastName.value,
        "email": this.controlerData.email.value,
        "age": this.controlerData.age.value,
        "dob": this.controlerData.dob.value,
        "courseId": this.controlerData.courseId.value,
        "address": {
          "city":this.controlerData.city.value,
          "address": this.controlerData.address.value
          
        },
        "telephones": [
          {"number":this.controlerData.number.value},
          {"number2":this.controlerData.number2.value}
          
         
        ]
        
        
        


        
      }
      console.log('SUBMIT');
      console.log(studentData);
      


      //passing to service
      this.studentsService.Addstudents(studentData)
        .subscribe(
          response => {
            console.log(response);
            this.submitted = false;
            this.studentDetailsregistration.reset();
          },
          error => {
            console.log(error);
            return;
          }
        )

    } else {
      return;
    }


  }

}