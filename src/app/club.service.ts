import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ClubService {



  constructor(private http:HttpClient) { }

  getClubs(){
    return this.http.get("http://localhost:8080/getClubs");
  }
  

    




}
