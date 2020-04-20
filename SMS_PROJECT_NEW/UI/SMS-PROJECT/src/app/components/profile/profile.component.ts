import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from 'src/app/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user:any;
  username:any;
  id:any;
  detailsEdit:FormGroup;
  submitted = false;
  constructor(private route: ActivatedRoute,
    
    private formBuilder:FormBuilder,
    private profileService:ProfileService,
   
    ) {
      this.username = sessionStorage.getItem('username');
     }

    ngOnInit() {
      this.detailsEdit = this.formBuilder.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        email: ['', Validators.required],
        number: ['', Validators.required],
        password: ['', Validators.required]
        
      });
      this.displayValueForm()
      
  
    }
  
    displayValueForm() {
     
     this.user = (this.route.snapshot.paramMap.get('username'));
     console.log("fgfg")
     console.log(this.user)
   
      
      this.profileService.getUser(this.username)
      .subscribe(
        data=>{
          console.log(data)
         this.detailsEdit.controls['firstName'].setValue(data[0].firstName);
         
         this.detailsEdit.controls['lastName'].setValue(data[0].lastName);
         this.detailsEdit.controls['email'].setValue(data[0].email);
         this.detailsEdit.controls['number'].setValue(data[0].mobile);
         this.detailsEdit.controls['password'].setValue(data[0].password);
         
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
              "mobile": this.controlerData.number.value,
              "password": this.controlerData.password.value
    
            
             
              
            }
            console.log('SUBMIT');
            console.log(Data);
            
      
      
            //passing to service
            this.profileService.updateProfile(Data)
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