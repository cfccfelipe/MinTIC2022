/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author carlos
 */
public class PanelControles extends JPanel {

    JButton jButton;
    JLabel jLabelFurgon;
    JTextField jText;
    JLabel jLabelDormir;
    JSpinner jSpinner;
    JCheckBox jCheck;
    JRadioButton jRButton;

    public PanelControles() {
        setLayout(new GridLayout(10, 1));
        jButton = new JButton("Iniciar animación");
        add(jButton);
        jLabelFurgon = new JLabel("Carga del Furgon:");
        add(jLabelFurgon);
        jText = new JTextField("UNAL");
        add(jText);
        jLabelDormir = new JLabel("Lapso de dormir: ");
        add(jLabelDormir);
        jSpinner = new JSpinner();
        jSpinner.setValue(100);
        add(jSpinner);

        jCheck = new JCheckBox("Carga");
        jCheck.setSelected(true);
        add(jCheck);
        jRButton = new JRadioButton("Adelante");
        jRButton.setSelected(true);
        add(jRButton);

    }

}
