import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherserviceService } from 'src/app/teacherservice.service';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-update-teachers',
  templateUrl: './update-teachers.component.html',
  styleUrls: ['./update-teachers.component.scss']
})
export class UpdateTeachersComponent implements OnInit {

  id:any;
  detailsEdit:FormGroup;
  submitted = false;
  Course : any;
  // selectValue:any;
  // fuleType=['Diesel','Petrol','Hibrid'];
  constructor(
    private route: ActivatedRoute,
    private teacherserviceService:TeacherserviceService,
    private formBuilder:FormBuilder,
    private courseserviceService:CourseserviceService,
    private router:Router
    
  ) { }

  

  ngOnInit() {
    this.detailsEdit = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      age: ['', Validators.required],
      dob: ['', Validators.required],
      courseID: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      number: ['', Validators.required],
      number2: ['', Validators.required]
      
    });
    this.displayValueForm()
    this.reloadData();

  }

  displayValueForm() {
    //get accutale route id 
   this.id = (this.route.snapshot.paramMap.get('id'));
   
   console.log(this.id);
 
    
    this.teacherserviceService.getTeacher(this.id)
    .subscribe(
      data=>{
        console.log(data)
       this.detailsEdit.controls['firstName'].setValue(data[0].firstName);
       
       this.detailsEdit.controls['lastName'].setValue(data[0].lastName);
       this.detailsEdit.controls['email'].setValue(data[0].email);
       this.detailsEdit.controls['age'].setValue(data[0].age);
       this.detailsEdit.controls['dob'].setValue(data[0].dob);
       this.detailsEdit.controls['courseID'].setValue(data[0].courseID);
       this.detailsEdit.controls['address'].setValue(data[0].address.address);
       this.detailsEdit.controls['city'].setValue(data[0].address.city);
       this.detailsEdit.controls['number'].setValue(data[0].telephones[0].number);
       this.detailsEdit.controls['number2'].setValue(data[0].telephones[1].number2);
       
      },
      error=>{
        console.group(error);
      },
      ()=>{
        console.log('Complete');
      }
    );
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
            "courseID": this.controlerData.courseID.value,
          
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
          this.teacherserviceService.updateTeacher(Data)
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
            alert("Updated")
            this.router.navigate(['teacher']);
    
        } else {
          return;
        }
    
    
      }
  

}