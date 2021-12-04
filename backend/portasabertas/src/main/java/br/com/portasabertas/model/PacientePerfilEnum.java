package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum PacientePerfilEnum {
    ADMIN(1L),
    PARCEIRO(2L);

    private final Long descricao;

    public Long getNumVal() {
        return descricao;
    }

}
