import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditService } from '../services/credit.service';

@Component({
  selector: 'app-add-immobilier',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-immobilier.component.html'
})
export class AddImmobilierComponent {

  data: any = { clientId: 1 };

  constructor(private service: CreditService) {}

  save() {
    this.service.addImmobilier(this.data)
      .subscribe(() => alert('Crédit immobilier ajouté'));
  }
}