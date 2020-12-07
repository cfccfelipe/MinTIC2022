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
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
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
        //Pinta barra superior
        setBackground(Color.YELLOW);
        //Pinta el fondo del panel general
        getContentPane().setBackground(Color.WHITE);

        //Agregando un ejemplo de border
        setLayout(new BorderLayout());
        //Agregar paneles no general
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Panel 1"));
        p1.setBackground(Color.LIGHT_GRAY);
        //Cambia el color del panel general por el de este panel este se convertira en el principal usado con flowlayout
        //setContentPane(p1);
        add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.add(new JLabel("Panel 2"));
        p2.setBackground(Color.CYAN);
        add(p2, BorderLayout.SOUTH);

        JPanel p3 = new JPanel();
        p3.add(new JLabel("Panel 3"));
        p3.setBackground(Color.ORANGE);
        add(p3, BorderLayout.CENTER);

        JPanel p4 = new JPanel();
        p4.add(new JLabel("Panel 4"));
        p4.setBackground(Color.RED);
        add(p4, BorderLayout.EAST);

        JPanel p5 = new JPanel();
        p5.add(new JLabel("Panel 5"));
        p5.setBackground(Color.WHITE);
        add(p5, BorderLayout.WEST);

    }
}
