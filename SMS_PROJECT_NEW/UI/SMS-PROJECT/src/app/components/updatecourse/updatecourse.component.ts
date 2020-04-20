import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-updatecourse',
  templateUrl: './updatecourse.component.html',
  styleUrls: ['./updatecourse.component.scss']
})
export class UpdatecourseComponent implements OnInit {

 
  id:any;
  

  detailsEdit:FormGroup;
  submitted = false;
  // selectValue:any;
  // fuleType=['Diesel','Petrol','Hibrid'];
  constructor(
    private route: ActivatedRoute,
    private courseserviceService:CourseserviceService,
    private formBuilder:FormBuilder,
    private router:Router
    
  ) { }

  

  ngOnInit() {
    this.detailsEdit = this.formBuilder.group({
      course_name: ['', Validators.required],
      
      
    });
    this.displayValueForm()


  }

  displayValueForm() {
    //get accutale route id 
   this.id = (this.route.snapshot.paramMap.get('id'));
   
   console.log(this.id);
 
    
    this.courseserviceService.getCourse(this.id)
    .subscribe(
      data=>{
        console.log(data)
       this.detailsEdit.controls['course_name'].setValue(data.course_name);
       
       
       
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
            "course_name": this.controlerData.course_name.value
            
          }
          console.log('SUBMIT');
          console.log(Data);
          //image eka yane Sting eka
    
    
          //passing to service
          this.courseserviceService.updateCourse(Data)
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
            this.router.navigate(['course']);
        } else {
          return;
        }
    
    
      }
  

}