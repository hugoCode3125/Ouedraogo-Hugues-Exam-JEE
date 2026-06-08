import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class CreditService {

  private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Génération dynamique des headers avec le token JWT
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token'); // Assure-toi que la clé est bien 'token'
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  // Utilisation d'un type d'ID robuste et passage des headers requis
  getCredits(clientId: number | string): Observable<any[]> {
    return this.http.get<any[]>(`${this.api}/credits/client/${clientId}`, {
      headers: this.getAuthHeaders()
    });
  }

  addPersonnel(data: any): Observable<any> {
    return this.http.post(`${this.api}/credits/personnel`, data, {
      headers: this.getAuthHeaders()
    });
  }

  addImmobilier(data: any): Observable<any> {
    return this.http.post(`${this.api}/credits/immobilier`, data, {
      headers: this.getAuthHeaders()
    });
  }

  addProfessionnel(data: any): Observable<any> {
    return this.http.post(`${this.api}/credits/professionnel`, data, {
      headers: this.getAuthHeaders()
    });
  }
}