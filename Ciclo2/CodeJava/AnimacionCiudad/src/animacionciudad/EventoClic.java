/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Auditor de los eventos generados por el ratón
 *
 * @author Camiku
 */
public class EventoClic implements ActionListener {

    private PanelControles panelControles;
    private JButton jButtonIniciar;
    private Hilo hilo;
    protected JButton jButtonParar;

    /**
     * Crea un auditor que tramita los eventos generados por la presión del
     * boton del ratón e inicializa la aplicación de forma independiente
     *
     * @param panelControles
     */
    public EventoClic(PanelControles panelControles) {
        this.panelControles = panelControles;
        this.jButtonIniciar = panelControles.getjButtonIniciar();
        this.jButtonParar = panelControles.getjButtonParar();
    }

    /**
     * Sobreescribe el método invocado cuando se presiona un boton que es
     * auditado por este objeto
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jButtonIniciar) {
            // Crea una nuevo hilo
            hilo = new Hilo(this.panelControles);
            // Desactiva el boton de ejecución
            jButtonIniciar.setEnabled(false);
            // Inicializa la ejecución del hilo
            hilo.start();}
        else if (ae.getSource() == jButtonParar) {
                // Crea una nuevo hilo
                hilo = new Hilo(this.panelControles);
                // Desactiva el boton de ejecución
                jButtonParar.setEnabled(false);
                // Inicializa la ejecución del hilo
                hilo.();
            
        }

    }
