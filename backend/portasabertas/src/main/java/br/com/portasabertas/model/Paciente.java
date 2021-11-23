package br.com.portasabertas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    @Column(name = "data_nascimento")
    LocalDate dataNascimento;
    String genero;
    String relato;
    String escolaridade;
    String profissao;
    String conhecimento;
    @ManyToOne
    StatusPaciente statusPaciente;
    @ManyToOne
    Psicologo psicologo;
    @OneToMany
    List<Agendamento> agendamentos;
    @OneToOne
    ResponsavelPaciente responsavelPaciente;
    @OneToOne
    EnderecoPaciente enderecoPaciente;
}
