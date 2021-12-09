import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Agenda } from './agenda/agenda.model';
import { environment } from 'src/environments/environment';
import {
  CriarAgendamentoRequestModel,
  PacienteMarcacao,
} from './marcar-agendamento/marcar.model';

const baseUrl = environment.baseUrl;
@Injectable({
  providedIn: 'root',
})
export class SuperService {
  constructor(private httpClient: HttpClient) {}

  getAgenda(): Observable<Array<Agenda>> {
    const psicologoId: number = 2;
    return this.httpClient.get<Array<Agenda>>(
      `${baseUrl}/api/agendamentos/filter?psicologoId=${psicologoId}`
    );
  }

  desmarcarAgendamento(id: number): Observable<string> {
    return this.httpClient.delete(`${baseUrl}/api/agendamentos/${id}`, {
      responseType: 'text',
    });
  }

  getPacientesAtivosParaPsicologo(
    psicologoId: number
  ): Observable<Array<PacienteMarcacao>> {
    return this.httpClient.get<Array<PacienteMarcacao>>(
      `${baseUrl}/api/pacientes/filter?psicologoId=${psicologoId}`
    );
  }

  criarAgendamento(
    agendamento: CriarAgendamentoRequestModel
  ): Observable<string> {
    return this.httpClient.post(`${baseUrl}/api/agendamentos`, agendamento, {
      responseType: 'text',
    });
  }
}
