package br.com.portasabertas.boundary.requestmodel.agendamento;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Builder
@Data
public class CreateAgendamentoRequestModel {
    @NotNull
    private Long pacienteId;
    @NotNull
    private Long psicologoId;
    @NotNull
    private LocalDateTime dataHora;
}
