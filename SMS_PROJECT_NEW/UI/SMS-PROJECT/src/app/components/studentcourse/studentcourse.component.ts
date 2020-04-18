import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseserviceService } from 'src/app/courseservice.service';

@Component({
  selector: 'app-studentcourse',
  templateUrl: './studentcourse.component.html',
  styleUrls: ['./studentcourse.component.scss']
})
export class StudentcourseComponent implements OnInit {
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
    this.courseserviceService.getCourseStudents(this.id)
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
