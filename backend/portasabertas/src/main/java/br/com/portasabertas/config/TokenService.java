package br.com.portasabertas.config;

import br.com.portasabertas.dao.PsicologoRepository;
import br.com.portasabertas.model.Psicologo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class TokenService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    @Autowired
    private PsicologoRepository psicologoRepository;

    public String gerarToken(Psicologo psi) {
        long expString = Long.parseLong(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        final var psicologo = psicologoRepository.findByCrp(psi.getCrp()).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado")
        );
        Date date = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());

        /*HashMap<String, Object> claims = new HashMap<>();

        claims.put("nome", psicologo.getNome());*/
        return Jwts
                .builder()
                .setSubject(psicologo.getId().toString())
                .setExpiration(date)
/*
                .setClaims(claims)
*/
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token) {
        try {
            final var claims = getClaims(token);
            Date dataExpiracao = claims.getExpiration();
            final var data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }

    public Long getPscologoId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.chaveAssinatura).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
