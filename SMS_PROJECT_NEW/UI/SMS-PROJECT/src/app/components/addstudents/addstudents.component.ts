import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

import { StudentsService } from '../../students.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CourseserviceService } from 'src/app/courseservice.service';
import Swal from 'sweetalert2'


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
    private courseserviceService:CourseserviceService,
    private router:Router
  ) {
    this.studentsService = studentsService;
  }

  

    

  ngOnInit() {
    this.studentDetailsregistration = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseId: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      number: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      number2: ['', [Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
      
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
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Submitted',
          showConfirmButton: true,
          timer: 5500
        })
        this.router.navigate(['students']);

    } else {
      return;
    }


  }

}