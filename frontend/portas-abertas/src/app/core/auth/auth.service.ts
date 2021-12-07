import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import {
  LoginRequestModel,
  LoginResponseModel,
} from 'src/app/features/login/login.model';
import { environment } from 'src/environments/environment';
import { UserService } from '../user/user.service';

const baseUrl = environment.baseUrl;
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(
    private httpClient: HttpClient,
    private userService: UserService
  ) {}

  auth(login: LoginRequestModel): Observable<LoginResponseModel> {
    return this.httpClient
      .post<LoginResponseModel>(`${baseUrl}/auth`, login)
      .pipe(
        tap((res) => {
          this.userService.registerUser(res.token);
        })
      );
  }
}
