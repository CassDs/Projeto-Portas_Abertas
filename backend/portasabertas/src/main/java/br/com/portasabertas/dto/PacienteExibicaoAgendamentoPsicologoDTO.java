package br.com.portasabertas.dto;

import br.com.portasabertas.model.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
public class PacienteExibicaoAgendamentoPsicologoDTO {
    Long id;
    String nome;
    String telefone;
    LocalDateTime dataHora;

   public static List<PacienteExibicaoAgendamentoPsicologoDTO> convertToPacienteAgendamentoDTOList(List<Agendamento> agendamentos) {
        return agendamentos.stream().map(agendamento -> {
            return PacienteExibicaoAgendamentoPsicologoDTO.builder()
                    .id(agendamento.getId())
                    .nome(agendamento.getPaciente().getNome())
                    .telefone(agendamento.getPaciente().getTelefone())
                    .dataHora(agendamento.getData())
                    .build();
        }).collect(Collectors.toList());
    }
}
