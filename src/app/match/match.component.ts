import { HttpClient } from '@angular/common/http';
import { Component, OnInit, NgModule } from '@angular/core';
import { Subscription } from 'rxjs';
import { MatchService } from '../match.service';
import { ClubService} from '../club.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css'],
  providers: [ClubService]
})

export class MatchComponent implements OnInit {

  messages: any[] = [];   
  subscription: Subscription;
  searchName :string="";
  match:any;
  showMainContent: Boolean = true;
  matches:any=[];

   constructor(private service:MatchService, private http:HttpClient, public _router:Router) {


    this.subscription = this.service.getMessage().subscribe(message => {
      if (message) {
        this.messages.push(message);
  
      } else {
        // clear messages when empty message received
        this.messages = [];
      }
    });
 
  }

  refresh(){   //This reloads the page from server
      this._router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this._router.navigate(["/matches"]));
   }
  

  ShowTitle() {

    if(this.showMainContent){
      this.getData();
    }else{
      this.clearMessages();
    }
    this.showMainContent = this.showMainContent ? false : true;
    //The generate button obtains toggle function to display the generated match content

 }

getData(){

  this.matches=this.getMatches().subscribe(data=>this.matches=data);

}

getMatches(){
  return this.http.get("http://localhost:8080/getMatch");
  //Retrieves the randomly generated match from backend
}

  clearMessages(): void {
      // clear messages
      this.service.clearMessages();
      this.showMainContent=true;

      this.refresh();
  }

    ngOnDestroy() {
      // unsubscribe to ensure no memory leaks
      this.subscription.unsubscribe();
     
    }
 
    ngOnInit(){
    this.match=this.service.getMatches().subscribe(data=>this.match=data);
    //loads the data from backend

  }

}


