/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Crea un auditor que tramita los eventos generados 
 * por la modificación de la lista de números
 * @author Camiku
 */
public class EventoCambioLista implements ChangeListener, MouseWheelListener {

    private JSpinner jSpinner;

    public EventoCambioLista(JSpinner jSpinner) {
        this.jSpinner = jSpinner;
    }

    /**
     * Tramita el evento cuando cambia el valor de la lista
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        jSpinner = (JSpinner) ce.getSource();
        int value;
        try {
            value = (Integer) jSpinner.getValue();
        } catch (NumberFormatException ne) {
            value = 1;
        }
        if (value < 1) {
            jSpinner.setValue(1);
        } else {
            jSpinner.setValue(value);
        }
    }

    /**
     * Tramita el evento cuando se mueve la rueda del raton 
     * @param mwe
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        jSpinner = (JSpinner) mwe.getSource();
        int wheel = mwe.getWheelRotation();
        if (wheel < 0) {
            int value = (Integer) jSpinner.getValue();
            value++;
            jSpinner.setValue(value);
        } else {
            int value = (Integer) jSpinner.getValue();
            if (value != 1) {
                value--;
            }
            jSpinner.setValue(value);
        }
    }
}
