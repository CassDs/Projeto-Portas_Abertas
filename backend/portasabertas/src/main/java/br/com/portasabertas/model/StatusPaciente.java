package br.com.portasabertas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "status_paciente")
public class StatusPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
    String observacao;
    @OneToMany
    List<Paciente> pacientes;
}
