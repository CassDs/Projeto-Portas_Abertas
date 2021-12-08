import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CadastroPacienteComponent } from './features/paciente/cadastro/cadastro-paciente.component';
import { HomeComponent } from './features/home/home.component';
import { LoginComponent } from './features/login/login.component';
import { SuperAdminComponent } from './features/super-admin/super-admin.component';
import { AuthGuard } from './core/auth/auth.guard';
import { AgendaComponent } from './features/super-admin/agenda/agenda.component';

const APP_ROUTES: Routes = [
  {
    path: 'superAdmin',
    //canActivate: [AuthGuard],
    loadChildren: () =>
      import('./features/super-admin/super.module').then((m) => m.SuperModule),
  },
  {
    path: 'cadastro-paciente',
    component: CadastroPacienteComponent,
    pathMatch: 'full',
  },
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
