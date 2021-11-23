package br.com.portasabertas.boundary.requestmodel;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CreatePacienteRequestModel {
    String conhecimento;
    LocalDate dataNascimento;
    String escolaridade;
    String genero;
    String nome;
    String profissao;
    String relato;
    String enderecoBairro;
    String enderecoLogradouro;
    String enderecoNumero;
}
