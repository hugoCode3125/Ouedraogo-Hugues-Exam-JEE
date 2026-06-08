
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreditComponent } from './credit/credit.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'credits', component: CreditComponent }
];