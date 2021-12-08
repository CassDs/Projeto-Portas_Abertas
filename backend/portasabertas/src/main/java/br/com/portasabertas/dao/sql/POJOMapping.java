package br.com.portasabertas.dao.sql;

import br.com.portasabertas.model.AgendamentoPacienteParaODiaPsicologo;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDateTime;

@SqlResultSetMapping(name = POJOMapping.GET_AGENDAMENTO_PARA_O_DIA_PSICOLOGO,
classes = @ConstructorResult(
        targetClass = AgendamentoPacienteParaODiaPsicologo.class,
        columns = {
                @ColumnResult(name = "pacienteNome", type = String.class),
                @ColumnResult(name = "pacienteTelefone", type = String.class),
                @ColumnResult(name = "data", type = LocalDateTime.class)
        }
))

public abstract class POJOMapping {
    public static final String GET_AGENDAMENTO_PARA_O_DIA_PSICOLOGO = "GetAgedamentoParaODiaPsicologo";
}
