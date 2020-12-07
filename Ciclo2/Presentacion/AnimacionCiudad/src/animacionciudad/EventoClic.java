/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

/**
 * Auditor de los eventos generados por el ratón
 *
 * @author Camiku
 */
public class EventoClic implements ActionListener {

    private JTextArea jTextArea;
    private JButton jButton;
    private JTextField jTextField;
    private JCheckBox jCheckBox;
    private JRadioButton jRadioAdelante;
    private JSpinner jSpinner;
    private Thread thread;
    private Hilo hilo;

    /**
     * Crea un auditor que tramita los eventos generados por la presión del
     * boton del ratón e inicializa la aplicación de forma independiente
     *
     * @param jTextArea
     * @param jButton
     * @param jTextField
     * @param jCheckBox
     * @param jRadioAdelante
     * @param jSpinner
     */
    public EventoClic(JTextArea jTextArea, JButton jButton, JTextField jTextField,
            JCheckBox jCheckBox, JRadioButton jRadioAdelante, JSpinner jSpinner) {
        this.jTextArea = jTextArea;
        this.jButton = jButton;
        this.jTextField = jTextField;
        this.jCheckBox = jCheckBox;
        this.jRadioAdelante = jRadioAdelante;
        this.jSpinner = jSpinner;
    }

    /**
     * Sobreescribe el método invocado cuando se presiona un boton que es
     * auditado por este objeto
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jButton) {
            // Crea una nuevo hilo
            hilo = new Hilo(jTextArea, jButton, jTextField,
                    jCheckBox, jRadioAdelante, jSpinner);
            Thread thread = new Thread(hilo, "Hilo para iniciar la animación");
            // Desactiva el boton de ejecución
            jButton.setEnabled(false);
            // Inicializa la ejecución del hilo
            thread.start();
        }
    }

}
