package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placas_rede")
public class PlacaRede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlacaRede;

    private String marca;
    private String modelo;
    private String chip;
    private String foto;

    public Long getIdPlacaRede() {
        return idPlacaRede;
    }

    public void setIdPlacaRede(Long idPlacaRede) {
        this.idPlacaRede = idPlacaRede;
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

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "PlacaRede [chip=" + chip + ", foto=" + foto + ", idPlacaRede=" + idPlacaRede + ", marca=" + marca
                + ", modelo=" + modelo + "]";
    }
}