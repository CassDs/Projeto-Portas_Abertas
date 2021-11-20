package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusPacienteEnum {
    AGUARDANDO(1L),
    ATIVO(2L),
    INATIVO(3L);

    private Long value;
}
