/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author carlos
 */
public class Comercial extends Vehiculo {

    //atributos
    public int peso_maximo;

    public Comercial(int velocidad, int cantidad, String placas, String tipo, int cargaM) {
        super(velocidad, cantidad, placas, tipo);
        this.peso_maximo = cargaM;
    }

    @Override
    public String toString() {
        return ("\t"+ "Vehículo " + tipo + " - Placa: " + placa + "\n" + "\t"+ "velocidad: " + velocidadmaxima + " km/h" + "\n" + "\t" + "pasajeros: " + cantidadpasajeros + "\n" + "\t" + "Carga máxima: " + peso_maximo + "kg");
    }
}
