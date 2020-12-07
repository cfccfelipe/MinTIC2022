/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import ciudad.Ciudad;
import ciudad.ParametrosDibujo;
import ciudad.Posicion;
import ciudad.Sitio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import vehiculo.Automovil;
import vehiculo.Deportivo;
import vehiculo.Furgon;
import vehiculo.Platon;
import vehiculo.Vehiculo;

/**
 * Hilo utilizado para iniciar un proceso independiente
 * @author Camiku
 */
public class Hilo extends Thread {

    private JTextArea jTextArea;
    private JButton jButtonIniciar;
    private JTextField jTextFieldCarga;
    private JCheckBox jCheckBoxVehiculosCarga;
    private JRadioButton jRadioButtonAdelante;
    private JSpinner jSpinnerDormir;
    
    public Hilo(PanelControles panelControles) {
        this.jTextArea = panelControles.getjTextArea();
        this.jButtonIniciar = panelControles.getjButtonIniciar();
        this.jTextFieldCarga = panelControles.getjTextFieldCarga();
        this.jCheckBoxVehiculosCarga = panelControles.getjCheckBoxVehiculosCarga();
        this.jRadioButtonAdelante = panelControles.getjRadioButtonAdelante();
        this.jSpinnerDormir = panelControles.getjSpinnerDormir();
    }

    /**
     * Inicializa la ejecución de la aplicación de forma independiente
     */
    @Override
    public void run() {
        Automovil automovil = new Automovil(new Posicion(), 5);
        Deportivo deportivo = new Deportivo(new Posicion(), 5);
        Platon camioneta = new Platon(new Posicion(), 3, 4);
        camioneta.llevar(ParametrosDibujo.CONTENIDO_CARGA);
        Furgon furgon = new Furgon(new Posicion(2, 50), 3, 4);
        furgon.llevar(jTextFieldCarga.getText());

        List<Vehiculo> listaVehiculos = new ArrayList();

        if (jCheckBoxVehiculosCarga.isSelected()) {
            listaVehiculos.add(camioneta);
            listaVehiculos.add(furgon);
        }

        List<Sitio> listaSitios = new ArrayList();
        for (int i = 0; i < ParametrosDibujo.NUMERO_SITIOS; i++) {
            listaSitios.add(new Sitio(new Posicion()));
        }

        Ciudad ciudad = new Ciudad(listaVehiculos, listaSitios);

        for (int i = 0; i < ParametrosDibujo.ITERACIONES_CIUDAD; i++) {
            if (jRadioButtonAdelante.isSelected()) {
                ciudad.mover();
            }
            jTextArea.setText(ciudad.pintar());
            try {
                sleep((Integer) jSpinnerDormir.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Reactiva el boton de ejecución
        jButtonIniciar.setEnabled(true);
        
        
    }

    
}
