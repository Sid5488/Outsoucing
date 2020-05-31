package br.com.solcode.outsourcing.security.auth;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.solcode.outsourcing.models.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    private String expiration;
    private String secret;

    public String generateToken(Authentication authentication) {
        Funcionario logged = (Funcionario) authentication.getPrincipal();
        Date date = new Date();
        Date dateExpiration = new Date(date.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("Authentication API")
            .setSubject(logged.getId().toString())
            .setIssuedAt(date)
            .setExpiration(dateExpiration)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUser(String token) {
        Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(body.getSubject());
    }
}