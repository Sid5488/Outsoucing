package br.com.solcode.outsourcing.resources.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginForm {
    
    private String email;
    private String senha;

    public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
    }
    
}