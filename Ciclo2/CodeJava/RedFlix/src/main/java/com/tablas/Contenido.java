/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contenido")
public class Contenido {

    @Id
    @Column(name = "cont_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contID;
    @Column(name = "cont_titulo")
    private String contTitulo;
    @Column(name = "cont_tipo")
    private Integer contTipo;

    @ManyToOne()
    @JoinColumn(name = "peli_titulo", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne()
    @JoinColumn(name = "serie_titulo", insertable = false, updatable = false)
    private Serie serie;

    @OneToMany(mappedBy = "transmision")
    private List<Transmision> transmision;

    public Integer getContID() {
        return contID;
    }

    public void setContID(Integer contID) {
        this.contID = contID;
    }

    public String getContTitulo() {
        return contTitulo;
    }

    public void setContTitulo(String contTitulo) {
        this.contTitulo = contTitulo;
    }

    public Integer getContTipo() {
        return contTipo;
    }

    public void setContTipo(Integer contTipo) {
        this.contTipo = contTipo;
    }

}
