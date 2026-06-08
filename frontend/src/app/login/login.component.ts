import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html'
})
export class LoginComponent {

  username = '';
  password = '';
  error = '';

  constructor(
    private auth: AuthService,
    private router: Router
  ) {}

  login() {
    this.error = '';

    this.auth.login({
      username: this.username,
      password: this.password
    }).subscribe({
      next: (token: string) => {
        this.auth.saveToken(token);
        this.router.navigate(['/credits']);
      },
      error: () => {
        this.error = 'Username ou password incorrect';
      }
    });
  }
}