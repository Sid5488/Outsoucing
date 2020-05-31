package br.com.solcode.outsourcing.models.estoque.impressoras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "impressoras")
@Data
public class Impressora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String marca;
    
    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String modelo;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String tipo;
}