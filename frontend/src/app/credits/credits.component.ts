import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditService } from '../services/credit.service';

@Component({
  selector: 'app-credits',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './credits.component.html'
})
export class CreditsComponent implements OnInit {

  credits: any[] = [];
  clientId = 1;

  constructor(private service: CreditService) {}

  ngOnInit(): void {
    this.loadCredits();
  }

  loadCredits() {
    this.service.getCredits(this.clientId)
      .subscribe(res => {
        this.credits = res;
      });
  }

  getType(c: any): string {
    if (c.typeBien) return 'IMMOBILIER';
    if (c.raisonSociale) return 'PROFESSIONNEL';
    return 'PERSONNEL';
  }

  badge(type: string) {
    switch (type) {
      case 'IMMOBILIER': return 'bg-primary';
      case 'PROFESSIONNEL': return 'bg-warning';
      default: return 'bg-success';
    }
  }
}