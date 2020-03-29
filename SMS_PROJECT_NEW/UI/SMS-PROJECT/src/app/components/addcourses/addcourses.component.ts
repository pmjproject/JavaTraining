import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-addcourses',
  templateUrl: './addcourses.component.html',
  styleUrls: ['./addcourses.component.scss']
})
export class AddcoursesComponent implements OnInit {

  courseDetailsregistration: FormGroup;
  submitted = false;
  imageUrl: any;



  
  private data: any[];
  

  constructor(private courseserviceService: CourseserviceService,
    private formBuilder: FormBuilder,
    private cd: ChangeDetectorRef
  ) {
    this.courseserviceService = courseserviceService;
  }

  ngOnInit() {
    this.courseDetailsregistration = this.formBuilder.group({
      course_name: ['', Validators.required],
      
    })

    // this.getOwners();
    
  }

 
  

  
  get controlerData() {
    return this.courseDetailsregistration.controls;
  }


  

  uploadSubmit() {
    this.submitted = true;

    if (this.courseDetailsregistration.valid) {
      let courseData = {
        "course_name": this.controlerData.course_name.value,
        
      }
      console.log('SUBMIT');
      console.log(courseData);
      //image eka yane Sting eka


      //passing to service
      this.courseserviceService.saveDetails(courseData)
        .subscribe(
          response => {
            console.log(response);
            this.submitted = false;
            this.courseDetailsregistration.reset();
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