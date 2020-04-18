import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherserviceService {
  private serverUrl: string ='http://localhost:8761/teacher/smsT';

    
  constructor(private http: HttpClient) {
      this.http = http;
  }

  saveDetails(data):Observable<any>{
      console.log('SERVICE');
      console.log(data);
      return this.http.post( this.serverUrl +'/addTeacher',data)
      // .pipe(map())
  
  }

  

  deleteTeacher(data){  
   
    return this.http.put(`${this.serverUrl}/deleteT`, data); 
  }  
  
  
  getTeacher(id){
   
    return this.http.get(this.serverUrl+`/getTeacherByID/${id}`)
  } 
  
  

  updateTeacher(Data) {
    console.log(Data)
   
    return this.http.put(this.serverUrl + '/updateTeacher', Data);
  }

  

  getTeacherList() {
    return this.http.get(this.serverUrl + '/allTeachers');
  }

}