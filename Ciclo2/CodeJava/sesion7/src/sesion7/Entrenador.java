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
public class Entrenador extends SeleccionFutbol {

    private String nacionalidad;
    private int ans;

    public Entrenador() {
        super();
    }

    public Entrenador(String nombre, int edad, int id, double salario, String nacionalidad, int ans) {
        super(nombre,edad,id,salario);
        this.nacionalidad = nacionalidad;
        this.ans = ans;
    }

}
