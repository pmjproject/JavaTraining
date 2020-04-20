import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private serverUrl: string ='http://localhost:8080';

    
  constructor(private http: HttpClient) {
      this.http = http;
  }

  
  getUser(username){
   
    return this.http.get(this.serverUrl+`/getUser/${username}`)
  } 
  
  

  updateProfile(Data) {
    console.log(Data)
   
    return this.http.put(this.serverUrl + '/updateUser', Data);
  }

  

}