package br.com.portasabertas.dto;

import br.com.portasabertas.model.Paciente;
import br.com.portasabertas.model.Psicologo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
public class PsicologoDTO {
    Long id;
    String nome;
    String crp;
    String email;
    Long perfilId;

    public static List<PsicologoDTO> convertToPsicologoDTOList(List<Psicologo> psicologoList) {
        return psicologoList.stream().map(psicologo -> {
            return PsicologoDTO.builder()
                    .id(psicologo.getId())
                    .nome(psicologo.getNome())
                    .crp(psicologo.getCrp())
                    .email(psicologo.getEmail())
                    .perfilId(psicologo.getPerfil().getId())
                    .build();
        }).collect(Collectors.toList());
    }
}
