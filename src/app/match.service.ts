import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

private subject = new Subject<any>();
constructor(private http:HttpClient) { }

getMatches(){
  return this.http.get("http://localhost:8080/getMatches");
}

sendMessage(message: string) {
    this.subject.next({ text: message });
    // A text message is passed
}

clearMessages() {
    this.subject.next();
    //An empty message is passes
}

getMessage(): Observable<any> {
    return this.subject.asObservable();
}



}
