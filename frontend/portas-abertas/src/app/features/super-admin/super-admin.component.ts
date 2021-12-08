import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/user/user.service';
declare const $;

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss'],
})
export class SuperAdminComponent {

  Name: string = "Cássio"

  constructor(private userService: UserService, private router: Router) {}
  ngAfterViewInit(): void {

  }

  ngOnInit(): void {
    this.exec();
    $('example').DataTable();
  }


  logout(): void {
    this.userService.logout();
    this.router.navigate(['/login']);
  }
  
  //Mnnu Lateral
  exec(){
    let list = document.querySelectorAll('.navigation li');
    function activeLink(){
      list.forEach((item) =>
      item.classList.remove('hovered'));
      this.classList.add('hovered');
    };
    list.forEach((item)=>
    item.addEventListener('mouseover',activeLink));

    //Encolher menu lateral

    let toggle = document.getElementById('toggle');
    let navigation = document.getElementById('navigation');
    let main = document.getElementById('main');
    let cardName = document.getElementById('cardName');
    let painel = document.getElementById('painelCentral');
    let homeText = document.getElementById('homeText');

    toggle.onclick = function(){
      navigation.classList.toggle('active');
      main.classList.toggle('active');
      cardName.classList.toggle('active');
      painel.classList.toggle('active');
      homeText.classList.toggle('active');
    }

    
    
  }
}
