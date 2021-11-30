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
@Table(name = "status_paciente")
@AllArgsConstructor
@NoArgsConstructor
public class StatusPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
    String observacao;
    @OneToMany
    List<Paciente> pacientes;
}
