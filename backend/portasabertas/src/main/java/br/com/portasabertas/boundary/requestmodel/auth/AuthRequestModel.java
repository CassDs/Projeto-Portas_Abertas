package br.com.portasabertas.boundary.requestmodel.auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Builder
@Data
public class AuthRequestModel {
    private String crp;
    private String senha;

    public UsernamePasswordAuthenticationToken covertToUserNamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(crp, senha);
    }
}
