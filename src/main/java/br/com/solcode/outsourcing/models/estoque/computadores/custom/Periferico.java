package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "perifericos")
public class Periferico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriferico;

    private String marca;
    private String modelo;
    private String descricao;
    private String foto;

    @ManyToOne
    private Desktop desktop;

    @Column(columnDefinition = "TEXT")
    private String tipo;

    public Long getIdPeriferico() {
        return idPeriferico;
    }

    public void setIdPeriferico(Long idPeriferico) {
        this.idPeriferico = idPeriferico;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Periferico [descricao=" + descricao + ", foto=" + foto + ", idPeriferico=" + idPeriferico + ", marca="
                + marca + ", modelo=" + modelo + ", tipo=" + tipo + "]";
    }

}