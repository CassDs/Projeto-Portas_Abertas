package br.com.portasabertas.config;

import br.com.portasabertas.dao.PsicologoRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final PsicologoRepository psicologoRepository;

    public AuthFilter(TokenService tokenService, PsicologoRepository psicologoRepository) {
        this.tokenService = tokenService;
        this.psicologoRepository = psicologoRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getToken(request);
        final var isValidToken = tokenService.isValidToken(token);

        if(isValidToken) {
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        final var token = request.getHeader("Authorization");

        if(Objects.isNull(token) || token.isEmpty() || !token.startsWith("Bearer")) {
            return null;
        }

        return token.split(" ")[1];
    }

    private void autenticarCliente(String token) {
        Long idUsuario = tokenService.getPscologoId(token);
        final var psicologo = psicologoRepository.findById(idUsuario).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado.")
        );
        UsernamePasswordAuthenticationToken authentication  =
                new UsernamePasswordAuthenticationToken(psicologo, null, psicologo.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

}
