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

    // saveCustomerOwnerDetails(customer){
    //     return this.http.post(this.serverUrl +'/service/save',customer)
    // }

    // saveRentDetails(rent){
    //     return this.http.post(this.serverUrl + '/service/save',rent)
    // }
    // getAllCars(){
    //     return this.http.get( this.serverUrl +'/service/findAllCars');
    // }
    // getOwners(){
    //     return this.http.get( this.serverUrl2 +'/service/get')
    // }

}