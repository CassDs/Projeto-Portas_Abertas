import { Component, OnInit } from '@angular/core';
import { SuperService } from '../super.service';
import { Agenda } from './agenda.model';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.scss'],
})
export class AgendaComponent implements OnInit {
  agendaList: Array<Agenda> = [];

  constructor(private superService: SuperService) {}

  ngOnInit(): void {
    this.loadAgenda();
    this.exec();
    
  }

  loadAgenda(): void {
    this.superService
      .getAgenda()
      .subscribe((agenda) => (this.agendaList = agenda));
  }

  exec(){
    
  }
  
}
