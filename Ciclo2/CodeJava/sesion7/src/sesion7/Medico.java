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
public class Medico extends SeleccionFutbol{

    private String especialidad;
    private String genero;

    public Medico() {
        super();
    }

    public Medico(String nombre, int edad, int id, double salario, String especialidad, String genero) {
        super(nombre, edad, id, salario);
        this.especialidad = especialidad;
        this.genero = genero;
    }
}
