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
    const pageFive = document.querySelector(".pageFive");
    const pageSix = document.querySelector(".pageSix");
    const pageSeven = document.querySelector(".pageSeven");
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

    nextEnd.addEventListener("click", function(){
      pageFour.setAttribute("style", "visibility: hidden;");
      pageFive.setAttribute("style", "visibility: visible;");
    });
    //button q5
    const backCont = document.querySelector(".backCont");
    const nextCont = document.querySelector(".nextCont");
  
    backCont.addEventListener("click", function(){
      pageFive.setAttribute("style", "visibility: hidden;");
      pageFour.setAttribute("style", "visibility: visible;");
    });  

    nextCont.addEventListener("click", function(){
      pageFive.setAttribute("style", "visibility: hidden;");
      pageSix.setAttribute("style", "visibility: visible;");  
    });
    //button q6
    const backEsc = document.querySelector(".backEsc");
    const nextEsc = document.querySelector(".nextEsc");

    backEsc.addEventListener("click", function(){
      pageSix.setAttribute("style", "visibility: hidden;");
      pageFive.setAttribute("style", "visibility: visible;");
    });  

    nextEsc.addEventListener("click", function(){
      pageSix.setAttribute("style", "visibility: hidden;");
      pageSeven.setAttribute("style", "visibility: visible;");  
    });
    //button q7
    const backTxt = document.querySelector(".backTxt");
    const nextTxt = document.querySelector(".nextTxt");

    backTxt.addEventListener("click", function(){
      pageSeven.setAttribute("style", "visibility: hidden;");
      pageSix.setAttribute("style", "visibility: visible;");
    });  

    /*nextTxt.addEventListener("click", function(){
      pageSeven.setAttribute("style", "visibility: hidden;");
      pageSeven.setAttribute("style", "visibility: visible;");  
    });*/


  }

}
