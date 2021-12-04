package br.com.portasabertas.dto;

import br.com.portasabertas.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
public class PacienteDTO {
    Long id;
    String nome;
    String relato;
    String telefone;

    public static List<PacienteDTO> convertToPacienteDTOList(List<Paciente> pacienteList) {
        return pacienteList.stream().map(paciente -> {
            return PacienteDTO.builder()
                    .id(paciente.getId())
                    .nome(paciente.getNome())
                    .relato(paciente.getRelato())
                    .telefone(paciente.getTelefone())
                    .build();
        }).collect(Collectors.toList());
    }
}
