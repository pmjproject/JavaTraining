import { Component, OnInit } from '@angular/core';
import { CourseserviceService } from 'src/app/courseservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-teachercourse',
  templateUrl: './teachercourse.component.html',
  styleUrls: ['./teachercourse.component.scss']
})
export class TeachercourseComponent implements OnInit {
  tableData : any;
  filter;
  p: number = 1;
  id:any;

  constructor(private courseserviceService:CourseserviceService,
   private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.id = (this.route.snapshot.paramMap.get('id'));
   
    console.log(this.id);
    this.courseserviceService.getCourseTeachers(this.id)
   .subscribe(
     response=>{
       console.log(response);
       this.tableData = response;
     },
     error=>{
       console.log(error);
     }
   )
    }

}
