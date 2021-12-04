package br.com.portasabertas.service;

import br.com.portasabertas.dao.PacienteRepository;
import br.com.portasabertas.dao.PsicologoRepository;
import br.com.portasabertas.model.Psicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PsicologoRepository psicologoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var psicologo = psicologoRepository.findByCrp(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        return User
                .builder()
                .username(psicologo.getCrp())
                .password(psicologo.getSenha())
                .roles(psicologo.getPerfil().getDescricao())
                .build();
    }
}
