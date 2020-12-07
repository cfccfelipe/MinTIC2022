/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class Ventana extends JFrame {

    public Ventana() {
        //Constructor JFrame: 
        //Toma como parametro el título de la ventana
        super("¡ Una animacion de una ciudad !");
        //Funcion para inicializar componentes
        initComponents();
        //Tamaño de la ventana
        //setSize(1000, 1000);
        //Reemplazamos setSize por pack que es ajustar de acuerdo al contenido
        pack();
        //Hacer visible la ventana
        setVisible(true);
        //Cierra la ejecucion de Jframe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        PanelCiudad panelCiudad = new PanelCiudad();
        setContentPane(panelCiudad);

        PanelControles panelControles = new PanelControles();
        add(panelControles);

    }
}
