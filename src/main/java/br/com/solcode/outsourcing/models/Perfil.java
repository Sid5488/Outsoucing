package br.com.solcode.outsourcing.models;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String type;

    @Override
    public String getAuthority() {
        
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
