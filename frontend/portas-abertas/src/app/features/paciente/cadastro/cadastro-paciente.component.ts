import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CadastrarPacienteRequestModel } from '../paciente.model';
import { PacienteService } from '../paciente.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.scss'],
})
export class CadastroPacienteComponent implements OnInit {
  form: FormGroup;
  

  constructor(
    private formbuilder: FormBuilder,
    private pacienteService: PacienteService
  ) {}

  ngOnInit(): void {
    this.startForm();
  }

  test() {
    //Paginas
    const pageOne = document.querySelector('.pageOne');
    const pageTwo = document.querySelector('.pageTwo');
    const pageThree = document.querySelector('.pageThree');
    const pageFour = document.querySelector('.pageFour');
    const pageFive = document.querySelector('.pageFive');
    const pageSix = document.querySelector('.pageSix');
    const pageSeven = document.querySelector('.pageSeven');
    const pageFinal = document.querySelector('.pageFinal');
    //Buton Inicial
    const firtNextBtn = document.querySelector('.nextBtn');

    firtNextBtn.addEventListener('click', function () {
      pageOne.setAttribute('style', 'visibility: hidden;');
      pageTwo.setAttribute('style', 'visibility: visible;');
    });
    //button q2
    const yes = document.querySelector('.yes');
    const nao = document.querySelector('.no');

    yes.addEventListener('click', function () {
      pageTwo.setAttribute('style', 'visibility: hidden;');
      pageThree.setAttribute('style', 'visibility: visible;');
    });
    //button q3
    const backInfo = document.querySelector('.backInfo');
    const nextInfo = document.querySelector('.nextInfo');

    backInfo.addEventListener('click', function () {
      pageThree.setAttribute('style', 'visibility: hidden;');
      pageTwo.setAttribute('style', 'visibility: visible;');
    });

    nextInfo.addEventListener('click', function () {
      pageThree.setAttribute('style', 'visibility: hidden;');
      pageFour.setAttribute('style', 'visibility: visible;');
    });
    //button q4
    const backEnd = document.querySelector('.backEnd');
    const nextEnd = document.querySelector('.nextEnd');

    backEnd.addEventListener('click', function () {
      pageFour.setAttribute('style', 'visibility: hidden;');
      pageThree.setAttribute('style', 'visibility: visible;');
    });

    nextEnd.addEventListener('click', function () {
      pageFour.setAttribute('style', 'visibility: hidden;');
      pageFive.setAttribute('style', 'visibility: visible;');
    });
    //button q5
    const backCont = document.querySelector('.backCont');
    const nextCont = document.querySelector('.nextCont');

    backCont.addEventListener('click', function () {
      pageFive.setAttribute('style', 'visibility: hidden;');
      pageFour.setAttribute('style', 'visibility: visible;');
    });

    nextCont.addEventListener('click', function () {
      pageFive.setAttribute('style', 'visibility: hidden;');
      pageSix.setAttribute('style', 'visibility: visible;');
    });
    //button q6
    const backEsc = document.querySelector('.backEsc');
    const nextEsc = document.querySelector('.nextEsc');

    backEsc.addEventListener('click', function () {
      pageSix.setAttribute('style', 'visibility: hidden;');
      pageFive.setAttribute('style', 'visibility: visible;');
    });

    nextEsc.addEventListener('click', function () {
      pageSix.setAttribute('style', 'visibility: hidden;');
      pageSeven.setAttribute('style', 'visibility: visible;');
    });
    //button q7
    const backTxt = document.querySelector('.backTxt');
    const nextTxt = document.querySelector('.nextTxt');

    backTxt.addEventListener('click', function () {
      pageSeven.setAttribute('style', 'visibility: hidden;');
      pageSix.setAttribute('style', 'visibility: visible;');
    });

    nextTxt.addEventListener('click', function () {
      pageSeven.setAttribute('style', 'visibility: hidden;');
      pageFinal.setAttribute('style', 'visibility: visible;');
    });
  }

  cadastrarPaciente(): void {
    let cadastrarPaciente: CadastrarPacienteRequestModel =
      this.form.getRawValue();
    /*     this.ngxSpinner.show();
     */ this.pacienteService.cadastrarPaciente(cadastrarPaciente).subscribe(
      () => {
        console.log('sucesso');
      },
      () => {
        console.log('erro');
      },
      () => {
        /*         this.ngxSpinner.hide();
         */
      }
    );
  }

  private startForm(): void {
    this.form = this.formbuilder.group({
      nome: this.formbuilder.control(''),
      dataNascimento: this.formbuilder.control(''),
      genero: this.formbuilder.control(''),
      cep: this.formbuilder.control(''),
      endereco: this.formbuilder.control(''),
      numero: this.formbuilder.control(''),
      bairro: this.formbuilder.control(''),
      cidade: this.formbuilder.control(''),
      estado: this.formbuilder.control(''),
      email: this.formbuilder.control(''),
      telefone: this.formbuilder.control(''),
      outroTelefone: this.formbuilder.control(''),
      profissao: this.formbuilder.control(''),
      escolaridade: this.formbuilder.control(''),
      conhecimento: this.formbuilder.control(''),
      comentario: this.formbuilder.control(''),
    });
  }
}
