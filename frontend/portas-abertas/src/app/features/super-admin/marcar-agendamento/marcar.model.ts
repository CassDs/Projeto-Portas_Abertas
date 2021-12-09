export interface PacienteMarcacao {
  id: number;
  nome: string;
}

export interface CriarAgendamentoRequestModel {
  pacienteId: number;
  psicologoId: number;
  dataHora: string;
}
