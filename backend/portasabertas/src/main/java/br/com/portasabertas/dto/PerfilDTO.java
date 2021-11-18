package br.com.portasabertas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
public class PerfilDTO {
    Long id;
    String descricao;

  /*  public static List<PerfilDTO> converterToList(List<PerfilDTO> perfilDTOList) {
        return  perfilDTOList.stream()
                .map(PerfilDTO::new)
                .collect(Collectors.toList());
    }*/
}
