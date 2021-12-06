import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
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
  }

  login(): void {
    let login: LoginRequestModel = this.formLogin.getRawValue();
    this.authService.auth(login).subscribe(
      () => {
        this.router.navigate(['/superAdmin']);
      },
      (error) => {
        this.toastrService.error('Dados inválidos');
      }
    );
  }

  private startFormLogin(): void {
    this.formLogin = this.formBuilder.group({
      crp: this.formBuilder.control(''),
      senha: this.formBuilder.control(''),
    });
  }
}
