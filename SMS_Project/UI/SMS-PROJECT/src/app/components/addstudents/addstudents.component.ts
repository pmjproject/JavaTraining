import { Component, OnInit } from '@angular/core';
import { Addstudents } from './addstudents';
import { AddstudentsService } from './addstudents.service';
// import { ActivatedRoute } from '@angular/router';
// import { Router } from '@angular/router';

@Component({
  selector: 'app-addstudents',
  templateUrl: './addstudents.component.html',
  styleUrls: ['./addstudents.component.scss']
})
export class AddstudentsComponent implements OnInit {
  
  addstudents:Addstudents;

  constructor(private addstudentsService:AddstudentsService) { }
  

  ngOnInit(): void {
    this.addstudents = new Addstudents(0,"", "", "", 0, "", 0, false,"","","");
  }

  saveStudent(): void{
    console.log(this.addstudents);
    this.addstudentsService.saveStudent(this.addstudents).subscribe(addstudents => this.addstudents = addstudents);
    // console.log("Saved Successfully");
    
  }

}
