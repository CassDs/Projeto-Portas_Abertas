package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "agendamento")
@Builder
@Data
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime data;
    @ManyToOne
    Paciente paciente;
    @ManyToOne
    Psicologo psicologo;
}
