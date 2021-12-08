import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuperRoutingModule } from './super.routing.module';
import { AgendaComponent } from './agenda/agenda.component';
import { RouterModule } from '@angular/router';
import { SuperAdminComponent } from './super-admin.component';
import { MarcarAgendamentoComponent } from './marcar-agendamento/marcar-agendamento.component';

@NgModule({
  declarations: [
    SuperAdminComponent,
    AgendaComponent,
    MarcarAgendamentoComponent,
  ],
  imports: [CommonModule, SuperRoutingModule, RouterModule],
})
export class SuperModule {}
