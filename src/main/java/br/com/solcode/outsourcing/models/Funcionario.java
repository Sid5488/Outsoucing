package br.com.solcode.outsourcing.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "funcionarios")
@Data
public class Funcionario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(11)")
    @Size(min = 11, max = 11)
    @CPF
    @NotNull
    private String cpf;

    @Column(columnDefinition = "VARCHAR(150)")
    @NotNull
    private String nome;

    @Column(columnDefinition = "VARCHAR(150)")
    @NotNull
    private String email;

    @Column(columnDefinition = "VARCHAR(150)")
    @Size(min = 5, max = 40)
    @NotNull
    private String senha;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Perfil> perfis;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfis;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}