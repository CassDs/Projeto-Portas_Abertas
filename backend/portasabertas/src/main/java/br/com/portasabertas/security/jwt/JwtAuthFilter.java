package br.com.portasabertas.security.jwt;

import br.com.portasabertas.service.UserDetailsServiceImpl;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthFilter(JwtService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final var authorization = request.getHeader("Authorization");

        if(!Objects.isNull(authorization) && authorization.startsWith("Bearer")) {
            final var token = authorization.split(" ")[1];
            if(jwtService.tokenIsValid(token)) {
                
            }
        }
    }
}
