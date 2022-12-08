package br.com.agenciaviagens.agenciaviagens.security.jwt;

import br.com.agenciaviagens.agenciaviagens.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String tempoExpiracao;
    @Value("${security.jwt.signkey}")
    private String chaveAssinatura;

    public JwtService() {
    }

    public String criarToken(Usuario usuario){
        long expiracaoLong = Long.valueOf(tempoExpiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expiracaoLong);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return Jwts.
                builder()
                .setSubject(usuario.getLogin())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }

    public String getTempoExpiracao() {
        return tempoExpiracao;
    }

    public void setTempoExpiracao(String tempoExpiracao) {
        this.tempoExpiracao = tempoExpiracao;
    }

    public String getChaveAssinatura() {
        return chaveAssinatura;
    }

    public void setChaveAssinatura(String chaveAssinatura) {
        this.chaveAssinatura = chaveAssinatura;
    }
}
