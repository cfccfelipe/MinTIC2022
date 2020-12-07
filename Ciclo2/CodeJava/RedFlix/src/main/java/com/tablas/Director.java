/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dir")
    private Integer dirId;
    @Column(name = "dir_nombre")
    private String dirNombre;
    @Column(name = "dir_apellido")
    private String dirApellido;
    @Column(name = "dir_nacionalidad")
    private String dirNacionalidad;
    
    @OneToMany(mappedBy ="pelicula")
    private List<Pelicula> peliculas;

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public String getDirNombre() {
        return dirNombre;
    }

    public void setDirNombre(String dirNombre) {
        this.dirNombre = dirNombre;
    }

    public String getDirApellido() {
        return dirApellido;
    }

    public void setDirApellido(String dirApellido) {
        this.dirApellido = dirApellido;
    }

    public String getDirNacionalidad() {
        return dirNacionalidad;
    }

    public void setDirNacionalidad(String dirNacionalidad) {
        this.dirNacionalidad = dirNacionalidad;
    }

}
