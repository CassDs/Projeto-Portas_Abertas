import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/core/user/user.service';
import { UtilsService } from 'src/app/shared/utils/utils.service';
import { SuperService } from '../super.service';
import { Agenda } from './agenda.model';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.scss'],
})
export class AgendaComponent implements OnInit {
  agendaList: Array<Agenda> = [];

  constructor(
    private superService: SuperService,
    private utilsService: UtilsService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.loadAgenda();
  }

  loadAgenda(): void {
    this.superService
      .getAgenda()
      .subscribe((agenda) => (this.agendaList = agenda));
  }

  extractWeekDay(date: Date): string {
    const days = {
      0: () => 'Domingo',
      1: () => 'Segunda',
      2: () => 'Terça',
      3: () => 'Quarta',
      4: () => 'Quinta',
      5: () => 'Sexta',
      6: () => 'Sábado',
    };
    const d = new Date(date);
    const weekday = d.getDay();
    return days[weekday]();
  }

  extractHour(date: Date): string {
    let d = new Date(date);
    return `${d.getHours()}:${this.returnMinuteWithZero(d.getMinutes())}`;
  }

  extractDate(date: Date): string {
    return this.utilsService.formatDate(date);
  }

  private returnMinuteWithZero(minute: number): string {
    if (minute >= 0 && minute < 10) {
      return `0${minute}`;
    }
    return minute.toString();
  }
}
