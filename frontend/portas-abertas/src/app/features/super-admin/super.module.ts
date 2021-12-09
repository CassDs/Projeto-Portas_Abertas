import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuperRoutingModule } from './super.routing.module';
import { AgendaComponent } from './agenda/agenda.component';
import { RouterModule } from '@angular/router';
import { SuperAdminComponent } from './super-admin.component';
import { MarcarAgendamentoComponent } from './marcar-agendamento/marcar-agendamento.component';
import { IConfig, NgxMaskModule } from 'ngx-mask';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
export const options: Partial<IConfig> | (() => Partial<IConfig>) = null;

@NgModule({
  declarations: [
    SuperAdminComponent,
    AgendaComponent,
    MarcarAgendamentoComponent,
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    SuperRoutingModule,
    RouterModule,
    NgxMaskModule.forRoot(),
    SharedModule,
  ],
})
export class SuperModule {}
