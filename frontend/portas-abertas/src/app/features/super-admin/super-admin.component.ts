import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/user/user.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss'],
})
export class SuperAdminComponent implements OnInit {
  Name: string = 'Cássio';

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.router.navigate(['/superAdmin/agenda']);
    this.exec();
  }

  logout(): void {
    this.userService.logout();
    this.router.navigate(['/login']);
  }

  redirectToAgendamento(): void {
    this.router.navigate(['/superAdmin/marcar-agendamento']);
  }

  redirectToAgenda(): void {
    this.router.navigate(['/superAdmin/agenda']);
  }

  getUserName(): string {
    return this.userService.getUserName();
  }

  //Mnnu Lateral
  exec() {
    let list = document.querySelectorAll('.navigation li');
    function activeLink() {
      list.forEach((item) => item.classList.remove('hovered'));
      this.classList.add('hovered');
    }
    list.forEach((item) => item.addEventListener('mouseover', activeLink));

    //Encolher menu lateral

    let toggle = document.getElementById('toggle');
    let navigation = document.getElementById('navigation');
    let main = document.getElementById('main');
    let cardName = document.getElementById('cardName');
    let homeText = document.getElementById('homeText');
    let painel = document.getElementById('painelCentral')
    let painelM = document.getElementById('painelCentralM')
    let tableAgenda = document.getElementById('table-agenda')

    toggle.onclick = function () {
      navigation.classList.toggle('active');
      main.classList.toggle('active');
      cardName.classList.toggle('active');
      homeText.classList.toggle('active');
      painel.classList.toggle('active');
      tableAgenda.classList.toggle('active');
      painelM.classList.toggle('active');
    };
  }
}
