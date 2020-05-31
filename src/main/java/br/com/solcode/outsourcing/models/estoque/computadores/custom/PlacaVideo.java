package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placas_video")
public class PlacaVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlacaVideo;

    @Column(columnDefinition = "VARCHAR(100)")
    private String marca;

    @Column(columnDefinition = "VARCHAR(100)")
    private String modelo;

    @Column(columnDefinition = "int")
    private String vRAM;

    @Column(columnDefinition = "text")
    private String especificacoes;

    private String foto;

    public Long getIdPlacaVideo() {
        return idPlacaVideo;
    }

    public void setIdPlacaVideo(Long idPlacaVideo) {
        this.idPlacaVideo = idPlacaVideo;
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

    public String getvRAM() {
        return vRAM;
    }

    public void setvRAM(String vRAM) {
        this.vRAM = vRAM;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "PlacaVideo [especificacoes=" + especificacoes + ", foto=" + foto + ", idPlacaVideo=" + idPlacaVideo
                + ", marca=" + marca + ", modelo=" + modelo + ", vRAM=" + vRAM + "]";
    }
}