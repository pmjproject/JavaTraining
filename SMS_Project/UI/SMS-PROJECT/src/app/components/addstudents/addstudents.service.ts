import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Addstudents } from './addstudents';
import { Observable } from 'rxjs';
// import { Observable } from 'rxjs/observable';
  



@Injectable({
  providedIn: 'root'
})
export class AddstudentsService {

  private addStudentsServiceURL = "http://localhost:8761/student/sms/addStudent"

  constructor(private http:HttpClient) { }

  saveStudent(addstudents : Addstudents): Observable<Addstudents>{
    return this.http.post<Addstudents>(this.addStudentsServiceURL, addstudents);
  }
}
