/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2;

/**
 *
 * @author carlos
 */
public class Particular extends Vehiculo {

    public String color;

    public Particular(int velocidad, int cantidad, String placas, String tipo, String color) {
        super(velocidad, cantidad, placas, tipo);
        this.color = color;
    }

    @Override
    public String toString() {
        
        return ("\t" + "Vehículo "+ tipo + " - Placa: " + placa + "\n" + "\t"+ "velocidad: " + velocidadmaxima + " km/h" +  "\n" + "\t"+ "pasajeros: " + cantidadpasajeros + "\n" + "\t" + "color: " + color);
    }
}
