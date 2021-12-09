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
    private Long id;
    private LocalDateTime data;
    boolean active;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Psicologo psicologo;
}
