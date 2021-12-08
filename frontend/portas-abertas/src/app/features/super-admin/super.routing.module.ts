import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgendaComponent } from './agenda/agenda.component';
import { MarcarAgendamentoComponent } from './marcar-agendamento/marcar-agendamento.component';

import { SuperAdminComponent } from './super-admin.component';

const APP_ROUTES: Routes = [
  {
    path: '',
    component: SuperAdminComponent,
    //canActivate: [AuthGuard],
    children: [
      {
        path: 'agenda',
        component: AgendaComponent,
      },
      {
        path: 'marcar-agendamento',
        component: MarcarAgendamentoComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(APP_ROUTES)],
  exports: [RouterModule],
})
export class SuperRoutingModule {}
