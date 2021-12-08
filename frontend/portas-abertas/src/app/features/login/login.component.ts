import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LOCAL_STORAGE } from 'src/app/constants';
import { AuthService } from 'src/app/core/auth/auth.service';
import { UserService } from 'src/app/core/user/user.service';
import { LoginRequestModel } from './login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private userService: UserService,
    private router: Router,
    private toastrService: ToastrService
  ) {}

  ngOnInit(): void {
    this.startFormLogin();
    this.rediretcToSuperAdminView();
  }

  login(): void {
    let crp = this.formLogin.value.crp;
    let senha = this.formLogin.value.senha;

    if (this.formLogin.valid) {
      let login: LoginRequestModel = this.formLogin.getRawValue();
      this.authService.auth(login).subscribe(
        () => {
          this.router.navigate(['/superAdmin']);
          let userId = window.localStorage.getItem(LOCAL_STORAGE.USER_ID);
          this.userService
            .getUserById(Number(userId))
            .subscribe((user) =>
              window.localStorage.setItem(LOCAL_STORAGE.USER_NAME, user?.nome)
            );
        },
        (error) => {
          this.toastrService.error('Dados inválidos');
        }
      );
    } else {
      if (!crp) {
        this.setErrorOnFormControlWhenIsBlank('crp');
      }

      if (!senha) {
        this.setErrorOnFormControlWhenIsBlank('senha');
      }
    }
  }

  private setErrorOnFormControlWhenIsBlank(formControlName: string): void {
    this.formLogin.get(formControlName).setErrors({ required: true });
    this.formLogin.get(formControlName).markAsTouched();
  }

  private startFormLogin(): void {
    this.formLogin = this.formBuilder.group({
      crp: this.formBuilder.control('', Validators.required),
      senha: this.formBuilder.control('', Validators.required),
    });
  }

  private rediretcToSuperAdminView(): void {
    if (this.userService.isLogged()) {
      this.router.navigate(['superAdmin']);
    }
  }
}
