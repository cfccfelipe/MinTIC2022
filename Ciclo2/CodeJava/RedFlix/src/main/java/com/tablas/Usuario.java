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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usr_alias")
    private String usrTitulo;
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Column(name = "usr_apellido")
    private String usrApellido;
    @Column(name = "usr_email")
    private String usrEmail;
    @Column(name = "usr_celular")
    private String usrCelular;
    @Column(name = "usr_contr")
    private String usrContrasenna;
    @Column(name = "usr_fnacimiento")
    private LocalDateTime usrFechana;

    @OneToMany(mappedBy = "transmision")
    private List<Transmision> transmision;

    public String getUsrTitulo() {
        return usrTitulo;
    }

    public void setUsrTitulo(String usrTitulo) {
        this.usrTitulo = usrTitulo;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(String usrCelular) {
        this.usrCelular = usrCelular;
    }

    public String getUsrContrasenna() {
        return usrContrasenna;
    }

    public void setUsrContrasenna(String usrContrasenna) {
        this.usrContrasenna = usrContrasenna;
    }

    public LocalDateTime getUsrFechana() {
        return usrFechana;
    }

    public void setUsrFechana(LocalDateTime usrFechana) {
        this.usrFechana = usrFechana;
    }

}
