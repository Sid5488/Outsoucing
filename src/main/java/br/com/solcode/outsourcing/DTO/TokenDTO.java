package br.com.solcode.outsourcing.DTO;

import lombok.Data;

@Data
public class TokenDTO {
    
    private String token;
    private String type;

    public TokenDTO(String token, String type) {
        this.token = token;
        this.type = type;
    }

}