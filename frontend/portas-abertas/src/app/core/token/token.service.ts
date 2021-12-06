import { Injectable } from '@angular/core';
import { LOCAL_STORAGE } from 'src/app/constants';

@Injectable({
  providedIn: 'root',
})
export class TokenService {
  constructor() {}

  hasToken(): boolean {
    return !!this.getToken();
  }

  getToken(): string {
    return window.localStorage.getItem(LOCAL_STORAGE.TOKEN_KEY);
  }

  getAuthorities(): Array<string> {
    return JSON.parse(window.localStorage.getItem(LOCAL_STORAGE.AUTHORITIES));
  }

  setToken(token: string): void {
    window.localStorage.setItem(LOCAL_STORAGE.TOKEN_KEY, token);
  }

  setAuthorities(authority: string): void {
    window.localStorage.setItem(LOCAL_STORAGE.AUTHORITIES, authority);
  }

  removeToken(): void {
    window.localStorage.removeItem(LOCAL_STORAGE.TOKEN_KEY);
    window.localStorage.removeItem(LOCAL_STORAGE.AUTHORITIES);
  }
}
