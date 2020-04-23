import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  // response:any;

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate(['/home'])
        this.invalidLogin = false
        
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Login is successfully',
          showConfirmButton: false,
          timer: 4500
        })
      },
      error => {
        this.invalidLogin = true
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Invalid Login',
          
        })

      }
    )
    );

  }
  // checkLogin() {
  // // public getAccessToken(username,password){
  //   let resp=this.loginservice.generateToken(this.username,this.password);
  //   resp.subscribe(data=>this.accessApi(data));
  //     }
    
    
  //     public accessApi(token){
  //   let resp=this.loginservice.welcome(token);
  //   resp.subscribe(data=>this.response=data);
  //     }
    }

