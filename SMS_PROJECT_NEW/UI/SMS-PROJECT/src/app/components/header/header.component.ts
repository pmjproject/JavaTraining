import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  username:any;

  constructor(private router: Router,
    public loginservice: AuthenticationService) { 
      // this.username = JSON.parse(sessionStorage.getItem('username'));
       this.username = sessionStorage.getItem('username');

    }


    details() {
      console.log(this.username)
   
     
   let user = this.username
   console.log(user)
    
     this.router.navigate(['/profile', user]);
  
    }
  ngOnInit(): void {
  }

}
