/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import ciudad.ParametrosDibujo;
import javax.swing.JPanel;
import javax.swing.JTextArea;



/**
 *
 * @author carlos
 */
public class PanelCiudad extends JPanel{
    JTextArea jTextArea;
    public PanelCiudad(){
        jTextArea = new JTextArea(ParametrosDibujo.ALTO, ParametrosDibujo.ANCHO);
        add(jTextArea);
    }
}
