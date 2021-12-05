package br.com.portasabertas.config;

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
public class AuthService implements UserDetailsService {

    @Autowired
    PsicologoRepository psicologoRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

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

    public UserDetails autenticar(Psicologo psicologo) {
        final var psi = loadUserByUsername(psicologo.getCrp());
        final var isMatch = passwordEncoder.matches(psicologo.getPassword(), psi.getPassword());

        if (isMatch) {
            return psi;
        } else {
            throw new UsernameNotFoundException("Usuário ou senha inválida");
        }

    }
}
