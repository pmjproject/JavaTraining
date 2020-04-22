import { Component, OnInit } from '@angular/core';
import { StudentsService } from 'src/app/students.service';

import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CourseserviceService } from 'src/app/courseservice.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-updatestudents',
  templateUrl: './updatestudents.component.html',
  styleUrls: ['./updatestudents.component.scss']
})
export class UpdatestudentsComponent implements OnInit {

  id:any;
  detailsEdit:FormGroup;
  submitted = false;
  
  selectValue:any;
  Course : any;
  // fuleType=['Diesel','Petrol','Hibrid'];
  constructor(
    private route: ActivatedRoute,
    private studentsService:StudentsService,
    private formBuilder:FormBuilder,
    private courseserviceService:CourseserviceService,
    private router:Router
    
  ) { }

  

  ngOnInit() {
    this.detailsEdit = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['',  [Validators.required, Validators.email]],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseId: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      number: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      number2: ['', [Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
      
    });
    this.displayValueForm()
    this.reloadData();

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

  displayValueForm() {
    //get accutale route id 
   this.id = (this.route.snapshot.paramMap.get('id'));
   
   console.log(this.id);
 
    
    this.studentsService.getStudent(this.id)
    .subscribe(
      data=>{
        console.log(data)
       this.detailsEdit.controls['firstName'].setValue(data[0].firstName);
       
       this.detailsEdit.controls['lastName'].setValue(data[0].lastName);
       this.detailsEdit.controls['email'].setValue(data[0].email);
       this.detailsEdit.controls['age'].setValue(data[0].age);
       this.detailsEdit.controls['dob'].setValue(data[0].dob);
      //  this.detailsEdit.controls['courseId'].setValue(data[0].courseId);
       
       this.detailsEdit.controls['address'].setValue(data[0].address.address);
       this.detailsEdit.controls['city'].setValue(data[0].address.city);
       this.detailsEdit.controls['number'].setValue(data[0].telephones[0].number);
       this.detailsEdit.controls['number2'].setValue(data[0].telephones[1].number2);
       this.detailsEdit.controls['courseId'].setValue(data[0].courseId);
       
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
              {"number":this.controlerData.number.value},
              {"number2":this.controlerData.number2.value}
             
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
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'Updated',
              showConfirmButton: true,
              timer: 5500
            })
            this.router.navigate(['students']);

    
        } else {
          return;
        }
    
    
      }
  

}