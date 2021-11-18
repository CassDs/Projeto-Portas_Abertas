package br.com.portasabertas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "responsavel_paciente")
public class ResponsavelPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String telefone;
    String grauParentesco;
    @OneToOne
    Paciente paciente;
}
