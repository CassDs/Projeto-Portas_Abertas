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
    //Paginas
    const pageOne = document.querySelector(".pageOne");
    const pageTwo = document.querySelector(".pageTwo");
    const pageThree = document.querySelector(".pageThree");
    const pageFour = document.querySelector(".pageFour");
    //Buton Inicial
    const firtNextBtn = document.querySelector(".nextBtn");

    firtNextBtn.addEventListener("click", function(){
      pageOne.setAttribute("style", "visibility: hidden;")
      pageTwo.setAttribute("style", "visibility: visible;")
    });
    //button q2
    const yes = document.querySelector(".yes");
    const nao = document.querySelector(".no");

    yes.addEventListener("click", function(){
      pageTwo.setAttribute("style", "visibility: hidden;");
      pageThree.setAttribute("style", "visibility: visible;");
    })
    //button q3
    const backInfo = document.querySelector(".backInfo");
    const nextInfo = document.querySelector(".nextInfo");

    backInfo.addEventListener("click", function(){
      pageThree.setAttribute("style", "visibility: hidden;");
      pageTwo.setAttribute("style", "visibility: visible;");
    });

    nextInfo.addEventListener("click", function(){
      pageThree.setAttribute("style", "visibility: hidden;");
      pageFour.setAttribute("style", "visibility: visible;");
    });
    //button q4
    const backEnd = document.querySelector(".backEnd");
    const nextEnd = document.querySelector(".nextEnd");

    backEnd.addEventListener("click", function(){
      pageFour.setAttribute("style", "visibility: hidden;");
      pageThree.setAttribute("style", "visibility: visible;");
    });
  
    

    


  }

}
