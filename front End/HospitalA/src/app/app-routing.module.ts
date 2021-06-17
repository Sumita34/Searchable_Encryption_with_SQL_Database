import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { DLoginComponent } from './d-login/d-login.component';
import { PLoginComponent } from './p-login/p-login.component'; 
import {PDashboardComponent} from './p-dashboard/p-dashboard.component';
import {DDashboardComponent} from './d-dashboard/d-dashboard.component';

const routes: Routes = [
  {path: 'login', component: LoginPageComponent},
  {path: 'registration', component: RegisterPageComponent},
  {path: 'login/doctorlogin', component: DLoginComponent},
  {path: 'login/patientlogin', component: PLoginComponent},
  {path: 'patientDashboard', component: PDashboardComponent},
  {path: 'doctorDashboard', component: DDashboardComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
