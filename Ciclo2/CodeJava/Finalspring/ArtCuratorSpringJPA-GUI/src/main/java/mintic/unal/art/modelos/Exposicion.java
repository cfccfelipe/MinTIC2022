/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.unal.art.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author joag
 */
@Entity
@Table(name = "exposicion")
public class Exposicion {
    
    @Id
    @GeneratedValue
    @Column(name="exp_id")
    Long expId;
    
    @Column(name="exp_nombre")
    String expNombre;

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public String getExpNombre() {
        return expNombre;
    }

    public void setExpNombre(String expNombre) {
        this.expNombre = expNombre;
    }

    @Override
    public String toString() {
        return "Exposicion{" + "expId=" + expId + ", expNombre=" + expNombre + '}';
    }

    
}
