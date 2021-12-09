import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.scss'],
})
export class InputTextComponent implements OnInit {
  filteredListaSugestoes: Array<any> = [];
  _listaSugestoes: Array<any> = [];
  displaySugestao: boolean;

  @Input() formControl: FormControl;
  @Input() iconeFa?: string;
  @Input() placeholder: string;
  @Input() type: string = 'text';

  @Input() set listaSugestoes(value) {
    this._listaSugestoes = value;
    this.filteredListaSugestoes = [...this._listaSugestoes];
  }

  @Output() mudarValor: EventEmitter<any> = new EventEmitter<any>();
  @Output() valorSelecionado: EventEmitter<any> = new EventEmitter<any>();

  public clicado: boolean = false;

  public valor: string = '';
  private onChange: Function;
  private onTouched: Function;

  constructor() {}

  ngOnInit() {
    if (!this.formControl) {
      throw Error('Informe o form control do componente input');
    }
  }

  isInvalido(): boolean {
    return !this.formControl.valid && !this.formControl.pristine;
  }

  selectValue(valor: any): void {
    this.mudarValor.emit(valor.id);
    this.formControl.setValue(valor.nome);
  }

  filterValue(value: string): void {
    if (value) {
      this.filteredListaSugestoes = this._listaSugestoes.filter((paciente) =>
        paciente.nome.toUpperCase().includes(value.toUpperCase())
      );
    } else {
      this.filteredListaSugestoes = [...this._listaSugestoes];
    }
  }

  registerOnChange(funcao: Function): void {
    this.onChange = funcao;
  }

  registerOnTouched(funcao: Function): void {
    this.onTouched = funcao;
  }

  changeDisplaySugestao(): void {
    if (!this.displaySugestao) {
      this.displaySugestao = true;
    }
  }

  focusoutDisplaySugestao(): void {
    this.displaySugestao = false;
  }

  showDisplaySugestao(): boolean {
    return this.filteredListaSugestoes?.length > 0;
  }

  selecionarValorSugestao(sugestao: any): void {
    //this.formControl.setValue(sugestao.descricao);
    this.valor = sugestao.descricao;
    this.valorSelecionado.emit(sugestao);
    /*     this.listaSugestoes = [];
     */
  }
}
