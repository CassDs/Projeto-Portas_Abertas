import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/core/user/user.service';
import { SuperService } from '../super.service';
import { CriarAgendamentoRequestModel, PacienteMarcacao } from './marcar.model';

@Component({
  selector: 'app-marcar-agendamento',
  templateUrl: './marcar-agendamento.component.html',
  styleUrls: ['./marcar-agendamento.component.scss'],
})
export class MarcarAgendamentoComponent implements OnInit {
  pacientes: Array<PacienteMarcacao> = [];
  formMarcar: FormGroup;
  selectedPacienteId: number;
  psicologoId: number;

  constructor(
    private superService: SuperService,
    private userService: UserService,
    private toastrService: ToastrService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.startFormControl();
    this.loadPacientesAtivosParaPsicologo();
    this.psicologoId = this.userService.getUserId();
  }

  onSelectPaciente(pacienteId: number): void {
    this.selectedPacienteId = pacienteId;
    console.log(this.selectedPacienteId);
  }

  loadPacientesAtivosParaPsicologo(): void {
    const psicologoId: number = this.userService.getUserId();
    this.superService.getPacientesAtivosParaPsicologo(psicologoId).subscribe(
      (pacientes) => {
        this.pacientes = pacientes;
      },
      () => {
        this.toastrService.error('Erro ao carregar pacientes');
      }
    );
  }

  marcarAgendamento(): void {
    const agendamento: CriarAgendamentoRequestModel = {
      pacienteId: this.selectedPacienteId,
      psicologoId: this.psicologoId,
      dataHora: this.formMarcar.value.data,
    };

    this.superService.criarAgendamento(agendamento).subscribe(
      (result) => {
        this.toastrService.success(result);
        this.formMarcar.reset();
      },
      () => {
        this.toastrService.error('Erro ao criar agendamento');
      }
    );
  }

  private startFormControl(): void {
    this.formMarcar = this.formBuilder.group({
      paciente: this.formBuilder.control('', Validators.required),
      data: this.formBuilder.control('', Validators.required),
    });
  }
}
