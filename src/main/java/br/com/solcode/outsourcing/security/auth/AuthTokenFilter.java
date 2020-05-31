package br.com.solcode.outsourcing.security.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.solcode.outsourcing.models.Funcionario;
import br.com.solcode.outsourcing.repositories.FuncionarioRepository;

public class AuthTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private FuncionarioRepository funcionarioRepository;

    public AuthTokenFilter(TokenService tokenService, FuncionarioRepository funcionarioRepository) {
        this.tokenService = tokenService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String token = retrieveToken(request);

                boolean valid = tokenService.isTokenValid(token);

                if(valid) {
                    authenticationCliente(token);
                }

                filterChain.doFilter(request, response);
    }

    private void authenticationCliente(String token) {
        Long idFuncionario = tokenService.getIdUser(token);
        Funcionario funcionario = funcionarioRepository.getOne(idFuncionario);
        UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(funcionario, null, funcionario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
    
}