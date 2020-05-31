package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placas_mae")
public class PlacaMae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlacaMae;

    private String marca;
    private String modelo;
    private String chipset;
    private String socket;
    private String tipoMemoriaRam;
    private String chipPlacaRede;
    private String foto;

    public Long getIdPlacaMae() {
        return idPlacaMae;
    }

    public void setIdPlacaMae(Long idPlacaMae) {
        this.idPlacaMae = idPlacaMae;
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

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getTipoMemoriaRam() {
        return tipoMemoriaRam;
    }

    public void setTipoMemoriaRam(String tipoMemoriaRam) {
        this.tipoMemoriaRam = tipoMemoriaRam;
    }

    public String getChipPlacaRede() {
        return chipPlacaRede;
    }

    public void setChipPlacaRede(String chipPlacaRede) {
        this.chipPlacaRede = chipPlacaRede;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "PlacaMae [chipPlacaRede=" + chipPlacaRede + ", chipset=" + chipset + ", foto=" + foto + ", idPlacaMae="
                + idPlacaMae + ", marca=" + marca + ", modelo=" + modelo + ", socket=" + socket + ", tipoMemoriaRam="
                + tipoMemoriaRam + "]";
    }
}