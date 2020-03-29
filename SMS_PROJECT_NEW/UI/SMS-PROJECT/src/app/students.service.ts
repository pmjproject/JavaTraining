import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})

export class StudentsService {
  

  private baseUrl = 'http://localhost:8761/student/sms';

  constructor(private http: HttpClient) { }



  Addstudents(students){
    return this.http.post(this.baseUrl+'/addStudent', students);
  }

  deleteStudent(data){  
    // return this.http.delete(`${this.baseUrl}/deleteS`, { responseType: 'text' });  
    return this.http.put(`${this.baseUrl}/deleteS`, data); 
  }  
  
  
  getStudent(id){
    return this.http.get(this.baseUrl+`/getStudent/${id}`)
  } 
  
  

  updateStudent(Data) {
    console.log(Data)
    return this.http.put(this.baseUrl + '/updateStudent', Data);
  }

  // getStudentsList(): Observable<any> {
  //   return this.http.get(`${this.baseUrl}/allStudents`);
  // }

  getStudentsList() {
    return this.http.get(this.baseUrl + '/allStudents');
  }

  
}
