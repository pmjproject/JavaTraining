import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TeacherserviceService } from 'src/app/teacherservice.service';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-addteacher',
  templateUrl: './addteacher.component.html',
  styleUrls: ['./addteacher.component.scss']
})
export class AddteacherComponent implements OnInit {

  teacherDetailsregistration: FormGroup;
  submitted = false;
  imageUrl: any;
  courseWithID: any;


  private data: any[];
  Course : any;
  

  constructor(private teacherserviceService: TeacherserviceService,
    private formBuilder: FormBuilder,
    private cd: ChangeDetectorRef,
    private courseserviceService:CourseserviceService
  ) {
    this.teacherserviceService = teacherserviceService;
  }

  ngOnInit() {
    this.teacherDetailsregistration = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseWithID: ['', Validators.required],
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
    return this.teacherDetailsregistration.controls;
  }


  

  uploadSubmit() {
    this.submitted = true;
    // let courseID = this.courseWithID.split('-')[0];
    // console.log(courseID);

    if (this.teacherDetailsregistration.valid) {
      let teacherData = {
        "firstName": this.controlerData.firstName.value,
        "lastName": this.controlerData.lastName.value,
        "email": this.controlerData.email.value,
        "age": this.controlerData.age.value,
        "dob": this.controlerData.dob.value,
        "courseID": this.controlerData.courseWithID.value,
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
      console.log(teacherData);
      //image eka yane Sting eka


      //passing to service
      this.teacherserviceService.saveDetails(teacherData)
        .subscribe(
          response => {
            console.log(response);
            this.submitted = false;
            this.teacherDetailsregistration.reset();
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