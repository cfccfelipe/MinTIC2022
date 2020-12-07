/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {
    
    @Id
    @Column(name = "serie_titulo")
    private String srTitulo;
    @Column(name = "serie_episodios")
    private Integer srEpisodios;
    @Column(name = "serie_temp")
    private Integer srTemp;

    public String getSrTitulo() {
        return srTitulo;
    }

    public void setSrTitulo(String srTitulo) {
        this.srTitulo = srTitulo;
    }

    public Integer getSrEpisodios() {
        return srEpisodios;
    }

    public void setSrEpisodios(Integer srEpisodios) {
        this.srEpisodios = srEpisodios;
    }

    public Integer getSrTemp() {
        return srTemp;
    }

    public void setSrTemp(Integer srTemp) {
        this.srTemp = srTemp;
    }

    
    
}
