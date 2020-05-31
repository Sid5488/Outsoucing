package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memorias_ram")
public class MemoriaRam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMemoriaRam;

    @Column(columnDefinition = "VARCHAR(100)")
    private String marca;

    @Column(columnDefinition = "VARCHAR(100)")
    private String modelo;
    
    private Long capacidade;

    @Column(columnDefinition = "VARCHAR(10)")
    private String tipo;

    private String foto;

    public Long getIdMemoriaRam() {
        return idMemoriaRam;
    }

    public void setIdMemoriaRam(Long idMemoriaRam) {
        this.idMemoriaRam = idMemoriaRam;
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

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "MemoriaRam [capacidade=" + capacidade + ", foto=" + foto + ", idMemoriaRam=" + idMemoriaRam + ", marca="
                + marca + ", modelo=" + modelo + ", tipo=" + tipo + "]";
    }
}