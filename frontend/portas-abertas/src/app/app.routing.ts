import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CadastroComponent } from './features/cadastro/cadastro.component';
import { HomeComponent } from './features/home/home.component';
import { LoginComponent } from './features/login/login.component';

const APP_ROUTES: Routes = [
    { path: 'cadastro', component: CadastroComponent },
    { path: 'login', component: LoginComponent },
    { path: '', component: HomeComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(APP_ROUTES)],
    exports: [RouterModule]
})
export class AppRoutingModule {}

