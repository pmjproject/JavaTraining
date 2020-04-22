import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private serverUrl: string ='http://localhost:8080';

  private httpOptions = {
    headers: new HttpHeaders({
      'Authorization':  sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };
  
  constructor(private http: HttpClient) {
      this.http = http;
  }

  
  getUser(username){
    const headers = new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization' : sessionStorage.getItem('token')
    });
    return this.http.get(this.serverUrl+`/getUser/${username}`,{headers:headers})
  } 
  
  

  updateProfile(Data) {
    console.log(Data)
   
    return this.http.put(this.serverUrl + '/updateUser', Data);
  }

  

}