package br.com.portasabertas.boundary.requestmodel.psicologo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class CreatePsicologoRequestModel {
    @NotNull @NotEmpty(message = "Informe o nome")
    String nome;
    @NotNull @NotEmpty(message = "Informe o nome de usuário")
    String username;
    @NotNull @NotEmpty(message = "Informe a senha")
    String senha;
    @NotNull @NotEmpty(message = "Informe o e-mail")
    String email;
    @NotNull @NotEmpty(message = "Informe o crp")
    String crp;
    @NotNull
    Long perfilId;
}
