import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss'],
})
export class SuperAdminComponent implements OnInit {

  Name: string = "Cássio"

  constructor() {}

  
  ngOnInit(): void {
    
    
    this.exec();
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

    toggle.onclick = function(){
      navigation.classList.toggle('active')
      main.classList.toggle('active')
      cardName.classList.toggle('active')

    }
  }
}
