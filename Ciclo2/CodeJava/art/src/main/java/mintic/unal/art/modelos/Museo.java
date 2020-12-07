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
@Table(name = "museo")
public class Museo {
    
    @Id
    @GeneratedValue
    @Column(name="mus_id")
    Long musId;
    
    @Column(name="mus_nombre")
    String musNombre;

    public Long getMusId() {
        return musId;
    }

    public void setMusId(Long musId) {
        this.musId = musId;
    }

    public String getMusNombre() {
        return musNombre;
    }

    public void setMusNombre(String musNombre) {
        this.musNombre = musNombre;
    }

    @Override
    public String toString() {
        return "Museo{" + "musId=" + musId + ", musNombre=" + musNombre + '}';
    }
   
}
