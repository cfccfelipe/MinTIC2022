/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import ciudad.ParametrosDibujo;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Panel utilizado para ubicar los controles de dibujo
 * @author Camiku
 */
public class PanelControles extends JPanel {

    // Área de texto para dibujar la ciudad
    protected JTextArea jTextArea = null;
    // Etiqueta del campo de texto de la carga
    protected JLabel jLabelCarga = null;
    // Etiqueta de la lista de cadenas del control del tiempo
    protected JLabel jLabelDormir = null;
    // Campo de texto del valor de la carga de los furgones
    protected JTextField jTextField = null;
    // Boton usado para iniciar la animación
    protected JButton jButton = null;
    // Lista de números del control del tiempo
    protected JSpinner jSpinner = null;
    // Boton de chequeo para establecer si aparecen los carros de carga
    protected JCheckBox jCheckBox = null;
    // Componente que agrupa un conjunto de botones de opción para 
    // que actuen sincronizados (i.e. que sólo uno pueda ser seleccionado) 
    protected ButtonGroup buttonGroup = null;
    // Botón de la opción de la dirección hacia adelante
    protected JRadioButton jRadioButton = null;

    /**
     * Crea un panel que servirá para ubicar los controles de dibujo
     * @param panelCiudad
     */
    public PanelControles(PanelCiudad panelCiudad) {
        this.jTextArea = panelCiudad.getjTextArea();
        initComponents();
    }

    /**
     * Inicia la creación de las componentes de control de dibujo
     */
    private void initComponents() {
        // Establece el gestor de organización en forma de retícula de tamaño 10x1
        setLayout(new GridLayout(10,1));
        
        jButton = new JButton("Iniciar animación");
        // Adiciona el botón a éste panel
        add(jButton);

        jLabelCarga = new JLabel("Carga del Furgon: ");
        add(jLabelCarga);

        jTextField = new JTextField("UNAL");
        add(jTextField);

        jLabelDormir = new JLabel("Lapso de dormir: ");
        add(jLabelDormir);

        jSpinner = new JSpinner();
        // Establece el valor por defecto de la lista de números
        jSpinner.setValue(ParametrosDibujo.PAUSA_MILISEGUNDOS);
        add(jSpinner);

        
        jCheckBox = new JCheckBox("Carga");
        // El boton de chequeo aparecerá seleccionado
        jCheckBox.setSelected(true);
        add(jCheckBox);
        
        jRadioButton = new JRadioButton("Adelante");
        // El boton de opción aparecerá seleccionado
        jRadioButton.setSelected(true);
        
        add(jRadioButton);
        
        buttonGroup = new ButtonGroup();
        // Adiciona el boton de opción a un grupo de botones
        buttonGroup.add(jRadioButton);

        // Crea un auditor que tramitará los eventos generados por el boton
        EventoClic eventoClic = new EventoClic(jTextArea, jButton, jTextField, jCheckBox,
                jRadioButton, jSpinner);

        // Establece como auditor al objeto eventoClic cuando se presiona el boton
        jButton.addActionListener(eventoClic);
        
        /* Crea un auditor que tramitará los eventos generados por la 
        lista de números del control del tiempo**/
        EventoCambioLista eventoCambioLista = new EventoCambioLista(jSpinner);
        
        // Establece como auditor al objeto eventoCambioLista cuando se 
        // gira la rueda del ratón
        jSpinner.addMouseWheelListener(eventoCambioLista);
        // Establece como auditor al objeto eventoCambioLista cuando se 
        // modifica la lista de números
        jSpinner.addChangeListener(eventoCambioLista);

    }

}
