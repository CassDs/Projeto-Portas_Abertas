import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/user/user.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss'],
})
export class SuperAdminComponent implements OnInit {

  Name: string = "Cássio"

  //public dados = [{name: 'Cassio', tel: '819999999', dia: 'Segunda', horario: '8:00'}];
  //dtOptions: DataTables.Settings = {};


  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    /*this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      lengthMenu : [5, 10, 15],
      processing: true
    }*/
    this.exec();

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
