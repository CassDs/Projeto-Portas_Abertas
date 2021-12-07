import { Injectable } from '@angular/core';
import { TokenService } from '../token/token.service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  profile: number;
  constructor(private tokenService: TokenService) {}

  registerUser(token: string): void {
    this.tokenService.setToken(token);
  }

  isLogged(): boolean {
    return this.tokenService.hasToken();
  }

  getProfile(): void {}

  logout(): void {
    this.tokenService.removeToken();
  }
}
