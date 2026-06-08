import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreditsComponent } from './credits/credits.component';
import { AddPersonnelComponent } from './add-personnel/add-personnel.component';
import { AddImmobilierComponent } from './add-immobilier/add-immobilier.component';
import { AddProfessionnelComponent } from './add-professionnel/add-professionnel.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },

  { path: 'credits', component: CreditsComponent },
  { path: 'add-personnel', component: AddPersonnelComponent },
  { path: 'add-immobilier', component: AddImmobilierComponent },
  { path: 'add-professionnel', component: AddProfessionnelComponent }
];