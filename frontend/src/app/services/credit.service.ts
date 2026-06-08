import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class CreditService {

  private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getCredits(clientId: number) {
  return this.http.get<any[]>(`${this.api}/credits/client/${clientId}`);
}

  addPersonnel(data: any) {
    return this.http.post(`${this.api}/credits/personnel`, data);
  }

  addImmobilier(data: any) {
    return this.http.post(`${this.api}/credits/immobilier`, data);
  }

  addProfessionnel(data: any) {
    return this.http.post(`${this.api}/credits/professionnel`, data);
  }

  addRemboursement(data: any) {
    return this.http.post(`${this.api}/credits/remboursement`, data);
  }
}