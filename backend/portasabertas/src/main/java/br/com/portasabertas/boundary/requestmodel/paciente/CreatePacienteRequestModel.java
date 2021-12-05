package br.com.portasabertas.boundary.requestmodel.paciente;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Builder
@Data
public class CreatePacienteRequestModel {
    @NotNull @NotBlank(message = "Informe o nome.")
    String nome;
    @NotNull
    LocalDate dataNascimento;
    @NotNull @NotBlank(message = "Informe o gênero")
    String genero;
    @NotNull @NotBlank(message = "Informe o CEP")
    String cep;
    @NotNull @NotBlank(message = "Informe o endereço")
    String endereco;
    @NotNull @NotBlank(message = "Informe o número")
    String numero;
    @NotNull @NotBlank(message = "Informe o bairro")
    String bairro;
    @NotNull @NotBlank(message = "Informe a cidade")
    String cidade;
    @NotNull @NotBlank(message = "Informe o estado")
    String estado;
    @NotNull @NotBlank(message = "Informe o e-mail")
    String email;
    @NotNull @NotBlank(message = "Informe o telefone")
    String telefone;
    @NotNull @NotBlank(message = "Informe outro telefone")
    String outroTelefone;
    @NotNull @NotBlank(message = "Informe a profissão")
    String profissao;
    @NotNull @NotBlank(message = "Informe a escolaridade")
    String escolaridade;
    @NotNull @NotBlank(message = "Informe o conhecimento")
    String conhecimento;
    String comentario;

}
