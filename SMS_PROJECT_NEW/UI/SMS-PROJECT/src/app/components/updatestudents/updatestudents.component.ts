import { Component, OnInit } from '@angular/core';
import { StudentsService } from 'src/app/students.service';

import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-updatestudents',
  templateUrl: './updatestudents.component.html',
  styleUrls: ['./updatestudents.component.scss']
})
export class UpdatestudentsComponent implements OnInit {

  id:any;
  detailsEdit:FormGroup;
  submitted = false;
  // selectValue:any;
  // fuleType=['Diesel','Petrol','Hibrid'];
  constructor(
    private route: ActivatedRoute,
    private studentsService:StudentsService,
    private formBuilder:FormBuilder
    
  ) { }

  

  ngOnInit() {
    this.detailsEdit = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseId: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      number: ['', Validators.required]
      
    });
    this.displayValueForm()


  }

  displayValueForm() {
    //get accutale route id 
   this.id = (this.route.snapshot.paramMap.get('id'));
   console.log(this.id);
 
    
    this.studentsService.getStudent(this.id)
    .subscribe(
      data=>{
      
       this.detailsEdit.controls['firstName'].setValue(data[0].firstName);
       this.detailsEdit.controls['lastName'].setValue(data[0].lastName);
       this.detailsEdit.controls['email'].setValue(data[0].email);
       this.detailsEdit.controls['age'].setValue(data[0].age);
       this.detailsEdit.controls['dob'].setValue(data[0].dob);
       this.detailsEdit.controls['courseId'].setValue(data[0].courseId);
       this.detailsEdit.controls['address'].setValue(data[0].address.address);
       this.detailsEdit.controls['city'].setValue(data[0].address.city);
       this.detailsEdit.controls['number'].setValue(data[0].telephones.number);
       
      },
      error=>{
        console.group(error);
      },
      ()=>{
        console.log('Complete');
      }
    );
  }

  




  get controlerData() {
    return this.detailsEdit.controls;
  }
  
  
  
      uploadSubmit() {
        this.submitted = true;
    
        if (this.detailsEdit.valid) {
          let Data = {
            "id": this.id,
            "firstName": this.controlerData.firstName.value,
            "lastName": this.controlerData.lastName.value,
            "email": this.controlerData.email.value,
            "age": this.controlerData.age.value,
            "dob": this.controlerData.dob.value,
            "courseId": this.controlerData.courseId.value,
          
            "address": {
              "address": this.controlerData.address.value,
              "city": this.controlerData.city.value
             
            },
            "telephones": [
              {"number":this.controlerData.number.value}
             
            ]
            
          }
          console.log('SUBMIT');
          console.log(Data);
          //image eka yane Sting eka
    
    
          //passing to service
          this.studentsService.updateStudent(Data)
            .subscribe(
              response => {
                console.log(response);
                this.submitted = false;
                this.detailsEdit.reset();
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