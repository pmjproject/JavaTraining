import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseserviceService {

  private serverUrl: string ='http://localhost:8761/course/smsC';

    
    constructor(private http: HttpClient) {
        this.http = http;
    }

    saveDetails(data):Observable<any>{
        console.log('SERVICE');
        console.log(data);
        return this.http.post( this.serverUrl +'/addCourse',data)
        // .pipe(map())
    
    }

    

    deleteCourse(data){  
      // return this.http.delete(`${this.baseUrl}/deleteS`, { responseType: 'text' });  
      return this.http.put(`${this.serverUrl}/deleteC`, data); 
    }  
    
    
    getCourse(id){
      return this.http.get(this.serverUrl+`/getCourseByID/${id}`)
    } 
    
    getCourseStudents(id){
      return this.http.get(this.serverUrl+`/courseStudent/${id}`)
    } 
    getCourseTeachers(id){
      return this.http.get(this.serverUrl+`/courseTeacher/${id}`)
    } 
    
  
    updateCourse(Data) {
      console.log(Data)
      return this.http.put(this.serverUrl + '/updateCourse', Data);
    }
  
    
  
    getCourseList() {
      return this.http.get(this.serverUrl + '/allCourse');
    }

    

}