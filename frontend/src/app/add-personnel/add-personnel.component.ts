import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditService } from '../services/credit.service';

@Component({
  selector: 'app-add-personnel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-personnel.component.html'
})
export class AddPersonnelComponent {

  data: any = { clientId: 1 };

  constructor(private service: CreditService) {}

  save() {
    this.service.addPersonnel(this.data)
      .subscribe(() => alert('Crédit personnel ajouté'));
  }
}