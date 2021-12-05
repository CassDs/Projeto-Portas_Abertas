package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.auth.AuthRequestModel;
import br.com.portasabertas.config.AuthService;
import br.com.portasabertas.config.TokenService;
import br.com.portasabertas.dao.PsicologoRepository;
import br.com.portasabertas.dto.TokenDTO;
import br.com.portasabertas.model.Psicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthService authService;
    @Autowired
    private PsicologoRepository psicologoRepository;

    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AuthRequestModel form){
        try{
          final var psicologo = Psicologo.builder()
                  .crp(form.getCrp())
                  .senha(form.getSenha())
                  .build();

          authService.autenticar(psicologo);
          final var token = tokenService.gerarToken(psicologo);

          return ResponseEntity.ok(TokenDTO.builder().token(token).build());
        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
