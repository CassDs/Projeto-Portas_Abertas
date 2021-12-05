package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    @Column(name = "data_nascimento")
    LocalDate dataNascimento;
    String genero;
    @Column(name = "relato", columnDefinition="varchar(5000)", length = 5000)
    String relato;
    String escolaridade;
    String profissao;
    String conhecimento;
    String telefone;
    @ManyToOne
    StatusPaciente statusPaciente;
    @ManyToOne
    Psicologo psicologo;
    @OneToMany
    List<Agendamento> agendamentos;
    @OneToOne
    ResponsavelPaciente responsavelPaciente;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Perfil> perfilList = new ArrayList<>();

}
