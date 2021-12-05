import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/auth/auth.service';
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
    private router: Router
  ) {}

  ngOnInit(): void {
    this.startFormLogin();
  }

  login(): void {
    let login: LoginRequestModel = this.formLogin.getRawValue();
    this.authService.auth(login).subscribe(
      (success) => {
        console.log(success.token);
        this.router.navigate(['/superAdmin']);
      },
      (error) => {
        console.log(error);
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
