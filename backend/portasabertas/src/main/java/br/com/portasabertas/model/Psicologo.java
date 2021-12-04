package br.com.portasabertas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "psicologo")
public class Psicologo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String username;
    String senha;
    String email;
    String crp;
    @ManyToOne
    Perfil perfil;
    @OneToMany
    List<Paciente> pacientes;
    @OneToMany
    List<Agendamento> agendamentos;

}
