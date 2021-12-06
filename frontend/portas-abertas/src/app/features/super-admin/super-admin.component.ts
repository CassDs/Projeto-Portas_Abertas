import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/user/user.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss'],
})
export class SuperAdminComponent implements OnInit {
  nome: string = 'Cassio';

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}

  logout(): void {
    this.userService.logout();
    this.router.navigate(['/login']);
  }
}
