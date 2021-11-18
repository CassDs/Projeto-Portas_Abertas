package br.com.portasabertas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Table(name = "agendamento")
public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime data;
    @ManyToOne
    Paciente paciente;
    @ManyToOne
    Psicologo psicologo;
}
