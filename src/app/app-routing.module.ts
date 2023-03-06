import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubComponent } from './club/club.component';
import { MatchComponent } from './match/match.component';

const routes: Routes = [
  {
    path:"matches", component: MatchComponent
  },

  {
    path:"clubs", component: ClubComponent
  },

  {
    path:"",redirectTo:"clubs", pathMatch:"full"  //this is to redirect to homepage
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],







exports: [RouterModule]
})
export class AppRoutingModule { }
