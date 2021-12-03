import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CadastrarPaciente } from './paciente.model';

const baseUrl = environment.baseUrl;

@Injectable({
  providedIn: 'root',
})
export class PacienteService {
  constructor(private httpClient: HttpClient) {}

  cadastrarPaciente(cadastrarPaciente: CadastrarPaciente): Observable<any> {
    return this.httpClient.post(`${baseUrl}/paciente`, { cadastrarPaciente });
  }
}
