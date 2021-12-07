import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CadastroPacienteComponent } from './features/paciente/cadastro/cadastro-paciente.component';
import { HomeComponent } from './features/home/home.component';
import { LoginComponent } from './features/login/login.component';
import { SuperAdminComponent } from './features/super-admin/super-admin.component';
import { AuthGuard } from './core/auth/auth.guard';

const APP_ROUTES: Routes = [
  {
    path: 'superAdmin',
    component: SuperAdminComponent,
    pathMatch: 'full',
    //canActivate: [AuthGuard],
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
