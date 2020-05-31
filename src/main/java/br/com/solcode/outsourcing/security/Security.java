package br.com.solcode.outsourcing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.solcode.outsourcing.repositories.FuncionarioRepository;
import br.com.solcode.outsourcing.security.auth.AuthService;
import br.com.solcode.outsourcing.security.auth.AuthTokenFilter;
import br.com.solcode.outsourcing.security.auth.TokenService;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Authentication Configuration
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {        
        auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Authorization setting
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/users").permitAll()
            .antMatchers(HttpMethod.GET, "/users/").permitAll()
            .antMatchers(HttpMethod.POST, "/users").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().addFilterBefore(new AuthTokenFilter(tokenService, funcionarioRepository),
                UsernamePasswordAuthenticationFilter.class);
    }

    // Static resource settings (HTML, CSS, IMGs, etc.). 
    // Não utilizaremos talvez mas vou deixar configurado
    @Override
    public void configure(WebSecurity web) throws Exception {
        
    }

}