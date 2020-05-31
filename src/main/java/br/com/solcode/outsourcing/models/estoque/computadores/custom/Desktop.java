package br.com.solcode.outsourcing.models.estoque.computadores.custom;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "desktops")
public class Desktop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesktop;

    @OneToOne
    @JoinColumn(name = "idPlacaMae")
    @Cascade({ CascadeType.SAVE_UPDATE })
    private PlacaMae placaMae;

    @OneToOne
    @JoinColumn(name = "idPlacaVideo")
    @Cascade({ CascadeType.SAVE_UPDATE })
    private PlacaVideo placaVideo;

    @OneToOne
    @JoinColumn(name = "idFonte")
    @Cascade({ CascadeType.SAVE_UPDATE })
    // @NotNull
    private Fonte fonte;

    @OneToOne
    @JoinColumn(name = "idMemoriaRam")
    @Cascade({ CascadeType.SAVE_UPDATE })
    private MemoriaRam memoriaRam;

    @OneToOne
    @JoinColumn(name = "idPlacaRede")
    @Cascade({ CascadeType.SAVE_UPDATE })
    private PlacaRede placaRede;

    @OneToMany(mappedBy = "desktop")
    // @Cascade(CascadeType.SAVE_UPDATE)
    private List<Periferico> perifericos;

    private String marca;

    private String tipo;

    public Long getIdDesktop() {
        return idDesktop;
    }

    public void setIdDesktop(Long idDesktop) {
        this.idDesktop = idDesktop;
    }

    public PlacaMae getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
    }

    public PlacaVideo getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(PlacaVideo placaVideo) {
        this.placaVideo = placaVideo;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public MemoriaRam getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(MemoriaRam memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public PlacaRede getPlacaRede() {
        return placaRede;
    }

    public void setPlacaRede(PlacaRede placaRede) {
        this.placaRede = placaRede;
    }

    public List<Periferico> getPerifericos() {
        return perifericos;
    }

    public void setPerifericos(List<Periferico> perifericos) {
        this.perifericos = perifericos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Desktop [fonte=" + fonte + ", idDesktop=" + idDesktop + ", marca=" + marca + ", memoriaRam="
                + memoriaRam + ", perifericos=" + perifericos + ", placaMae=" + placaMae + ", placaRede=" + placaRede
                + ", placaVideo=" + placaVideo + "]";
    }

}