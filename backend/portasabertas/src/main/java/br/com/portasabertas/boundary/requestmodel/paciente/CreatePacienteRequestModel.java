package br.com.portasabertas.boundary.requestmodel.paciente;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Builder
@Data
public class CreatePacienteRequestModel {
    @NotNull @NotBlank(message = "Informe a conhecimento.")
    String conhecimento;
    @NotNull
    LocalDate dataNascimento;
    @NotNull @NotBlank(message = "Informe a escolaridade.")
    String escolaridade;
    @NotNull @NotBlank(message = "Informe o gênero.")
    String genero;
    @NotNull @NotBlank(message = "Informe o nome.")
    String nome;
    @NotNull @NotBlank(message = "Informe o telefone.")
    String telefone;
    @NotNull @NotBlank(message = "Informe a profissão.")
    String profissao;
    @NotNull @NotBlank(message = "Informe o relato.")
    String relato;
    @NotNull @NotBlank(message = "Informe o bairro.")
    String enderecoBairro;
    @NotNull @NotBlank(message = "Informe o logradouro.")
    String enderecoLogradouro;
    @NotNull @NotBlank(message = "Informe o número.")
    String enderecoNumero;
}
