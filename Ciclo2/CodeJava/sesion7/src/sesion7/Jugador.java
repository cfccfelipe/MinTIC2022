/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion7;

/**
 *
 * @author carlos
 */
public class Jugador extends SeleccionFutbol {

    //Nuevos atributos no en padre
    private String posicion;
    private int dorsal;

    //Constructor vacio
    public Jugador() {
        super();
    }
// Constructor full

    public Jugador(String nombre, int edad, int id, double salario, String posicion, int dorsal) {
        super(nombre, edad, id, salario);
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

}
