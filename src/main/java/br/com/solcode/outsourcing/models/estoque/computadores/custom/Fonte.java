package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fontes")
public class Fonte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonte;

    private String marca;
    private String modelo;
    private String frequencia;
    private String foto;

    @Column(columnDefinition = "text")
    private String descricao;

    public Long getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(Long idFonte) {
        this.idFonte = idFonte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Fonte [descricao=" + descricao + ", foto=" + foto + ", frequencia=" + frequencia + ", idFonte="
                + idFonte + ", marca=" + marca + ", modelo=" + modelo + "]";
    }
}