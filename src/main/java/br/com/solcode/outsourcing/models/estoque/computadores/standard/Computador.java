package br.com.solcode.outsourcing.models.estoque.computadores.standard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "computadores")
public class Computador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String fonte;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String memoriaRam;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String mouse;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String teclado;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String placaMae;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String placaRede;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String placaVideo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(String placaMae) {
        this.placaMae = placaMae;
    }

    public String getPlacaRede() {
        return placaRede;
    }

    public void setPlacaRede(String placaRede) {
        this.placaRede = placaRede;
    }

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }

    @Override
    public String toString() {
        return "Computador [fonte=" + fonte + ", id=" + id + ", memoriaRam=" + memoriaRam + ", mouse=" + mouse
                + ", placaMae=" + placaMae + ", placaRede=" + placaRede + ", placaVideo=" + placaVideo + ", teclado="
                + teclado + "]";
    }

}