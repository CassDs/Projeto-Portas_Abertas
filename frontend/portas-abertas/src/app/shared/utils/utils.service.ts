import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UtilsService {
  constructor() {}

  formatDate(date: Date): string {
    const d = new Date(date);
    return `${d.getDate()}/${d.getMonth() / d.getFullYear()}`;
  }
}
