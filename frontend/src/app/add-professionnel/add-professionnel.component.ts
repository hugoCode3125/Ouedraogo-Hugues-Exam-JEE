import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditService } from '../services/credit.service';

@Component({
  selector: 'app-add-professionnel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-professionnel.component.html'
})
export class AddProfessionnelComponent {

  data: any = { clientId: 1 };

  constructor(private service: CreditService) {}

  save() {
    this.service.addProfessionnel(this.data)
      .subscribe(() => alert('Crédit professionnel ajouté'));
  }
}