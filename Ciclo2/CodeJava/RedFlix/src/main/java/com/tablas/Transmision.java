/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transmision")
public class Transmision {

    @Id
    @Column(name = "tr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trID;
    @Column(name = "tr_usuario")
    private String trUsuario;
    @Column(name = "tr_contenido")
    private Integer trContenido;
    @Column(name = "tr_fechahora")
    private LocalDateTime trFechaHora;

    @ManyToOne()
    @JoinColumn(name = "usr_alias", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "cont_id", insertable = false, updatable = false)
    private Contenido contenido;

    public Integer getTrID() {
        return trID;
    }

    public void setTrID(Integer trID) {
        this.trID = trID;
    }

    public String getTrUsuario() {
        return trUsuario;
    }

    public void setTrUsuario(String trUsuario) {
        this.trUsuario = trUsuario;
    }

    public Integer getTrContenido() {
        return trContenido;
    }

    public void setTrContenido(Integer trContenido) {
        this.trContenido = trContenido;
    }

    public LocalDateTime getTrFechaHora() {
        return trFechaHora;
    }

    public void setTrFechaHora(LocalDateTime trFechaHora) {
        this.trFechaHora = trFechaHora;
    }

}
