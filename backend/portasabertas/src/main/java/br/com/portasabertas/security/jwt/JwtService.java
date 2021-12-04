package br.com.portasabertas.security.jwt;

import br.com.portasabertas.model.Psicologo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class JwtService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Psicologo psicologo) {
        long expString = Long.parseLong(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Date date = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("perfil", psicologo.getPerfil().getDescricao());
        return Jwts
                .builder()
                .setSubject(psicologo.getCrp())
                .setExpiration(date)
                .setClaims(claims)
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

    public boolean tokenIsValid(String token) {
        try {
            final var claims = getClaims(token);
            Date dataExpiracao = claims.getExpiration();
            final var data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }
}
