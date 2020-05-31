package br.com.solcode.outsourcing.security.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.solcode.outsourcing.repositories.FuncionarioRepository;
import br.com.solcode.outsourcing.models.Funcionario;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Funcionario> funcionario = funcionarioRepository.findByemail(username);
        
        if(funcionario.isPresent()) {
            return funcionario.get();
        }

        throw new UsernameNotFoundException("Data invalid");
    }
    
}