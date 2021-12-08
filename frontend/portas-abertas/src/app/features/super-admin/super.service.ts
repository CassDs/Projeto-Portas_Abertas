import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Agenda } from './agenda/agenda.model';
import { environment } from 'src/environments/environment';

const baseUrl = environment.baseUrl;
@Injectable({
  providedIn: 'root',
})
export class SuperService {
  constructor(private httpClient: HttpClient) {}

  getAgenda(): Observable<Array<Agenda>> {
    const psicologoId: number = 2;
    const dateTime: string = '2021-12-07T12:00';
    return this.httpClient.get<Array<Agenda>>(
      `${baseUrl}/api/agendamentos/filter?psicologoId=${psicologoId}&dateTime=${dateTime}`
    );
  }
}
