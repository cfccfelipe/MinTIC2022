package com.tablas;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @Column(name = "peli_titulo")
    private String peliTitulo;
    @Column(name = "peli_resumen")
    private String peliResumen;
    @Column(name = "peli_anno")
    private Integer peliAnno;

    @ManyToOne()
    @JoinColumn(name = "peli_director", insertable = false, updatable = false)
    private Director director;

    @OneToMany(mappedBy = "contenido")
    private List<Contenido> contenidos;

    public String getPeliTitulo() {
        return peliTitulo;
    }

    public void setPeliTitulo(String peliTitulo) {
        this.peliTitulo = peliTitulo;
    }

    public String getPeliResumen() {
        return peliResumen;
    }

    public void setPeliResumen(String peliResumen) {
        this.peliResumen = peliResumen;
    }

    public Integer getPeliAnno() {
        return peliAnno;
    }

    public void setPeliAnno(Integer peliAnno) {
        this.peliAnno = peliAnno;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
