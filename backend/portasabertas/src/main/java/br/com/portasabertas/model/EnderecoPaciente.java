package br.com.portasabertas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "endereco_paciente")
public class EnderecoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String logradouro;
    String bairro;
    String numero;
    String cidade;
    String estado;
    String pais;
    String telefone;
    @OneToOne
    Paciente paciente;
}
