import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ClubService} from '../club.service';

@Component({
  selector: 'app-club',
  templateUrl: './club.component.html',
  styleUrls: ['./club.component.css'],
  providers: [ClubService]
})
export class ClubComponent implements OnInit {

  clubs:any=[];
  
  constructor(private service:ClubService, private http:HttpClient) {
 
   }

   ngOnInit(){
    this.clubs=this.service.getClubs().subscribe(data=>this.clubs=data);
   
  }
 

}

