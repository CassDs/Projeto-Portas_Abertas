package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoPacienteParaODiaPsicologo {
    private LocalDateTime dataHora;
    private String pacienteNome;
    private String pacienteTelefone;
}
