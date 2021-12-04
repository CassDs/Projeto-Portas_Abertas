package br.com.portasabertas.dto;

import br.com.portasabertas.model.Perfil;
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

   public static List<PerfilDTO> convertToPerfilDTOList(List<Perfil> perfilList) {
       return perfilList.stream().map(perfil -> {
           return PerfilDTO.builder()
                   .id(perfil.getId())
                   .descricao(perfil.getDescricao())
                   .build();
       }).collect(Collectors.toList());
   }
}
