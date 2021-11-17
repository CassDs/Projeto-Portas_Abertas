import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  test(){
    const slidePage = document.querySelector(".slidepage");
    const firtNextBtn = document.querySelector(".nextBtn");
  
    firtNextBtn.addEventListener("click", function(){
    slidePage.setAttribute("style", "margin-left:-25%;")
  });
  }

}
