import { Injectable } from '@angular/core';
import { TokenService } from '../token/token.service';
import jwt_decode from 'jwt-decode';
import { LOCAL_STORAGE } from 'src/app/constants';
import { User, UserToken } from './user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const baseUrl = environment.baseUrl;
@Injectable({
  providedIn: 'root',
})
export class UserService {
  profile: number;
  constructor(
    private tokenService: TokenService,
    private httpClient: HttpClient
  ) {}

  registerUser(token: string): void {
    this.tokenService.setToken(token);
    this.decodeAndNotify();
  }

  isLogged(): boolean {
    return this.tokenService.hasToken();
  }

  getProfile(): void {}

  logout(): void {
    this.tokenService.removeToken();
  }

  getUserById(userId: number): Observable<User> {
    return this.httpClient.get<User>(`${baseUrl}/api/psicologos/${userId}`);
  }

  getUserName(): string {
    return window.localStorage.getItem(LOCAL_STORAGE.USER_NAME);
  }

  private decodeAndNotify(): void {
    const token = this.tokenService.getToken();
    const user = jwt_decode(token) as UserToken;
    window.localStorage.setItem(LOCAL_STORAGE.USER_ID, user.sub);
  }
}
