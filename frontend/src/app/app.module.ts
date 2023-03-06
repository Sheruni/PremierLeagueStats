import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { FilterPipe } from './filter.pipe';
import { SortDirective } from './directive/sort.directive';
import { ClubComponent } from './club/club.component';
import { MatchComponent } from './match/match.component';
import { ClubService } from './club.service';



@NgModule({
  declarations: [
    AppComponent,
    FilterPipe,
    SortDirective,
    ClubComponent,
    MatchComponent
  ],

  imports: [
  BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  
  ],
  providers: [ClubService],
  bootstrap: [AppComponent]
})
export class AppModule { }
