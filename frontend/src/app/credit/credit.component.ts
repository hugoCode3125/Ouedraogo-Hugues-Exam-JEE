import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditService } from '../services/credit.service';

@Component({
  selector: 'app-credit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './credit.component.html'
})
export class CreditComponent implements OnInit {

  clientId = 1;
  credits: any[] = [];

  personnel: any = { clientId: 1 };
  immobilier: any = { clientId: 1 };
  professionnel: any = { clientId: 1 };

  constructor(private service: CreditService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.service.getCredits(this.clientId).subscribe((res: any[]) => {
      this.credits = res;
    });
  }

  addPersonnel() {
    this.service.addPersonnel(this.personnel)
      .subscribe(() => this.load());
  }

  addImmobilier() {
    this.service.addImmobilier(this.immobilier)
      .subscribe(() => this.load());
  }

  addProfessionnel() {
    this.service.addProfessionnel(this.professionnel)
      .subscribe(() => this.load());
  }

  badge(statut: string) {
    if (statut === 'ACCEPTE') return 'bg-success';
    if (statut === 'REJETE') return 'bg-danger';
    return 'bg-warning';
  }
}