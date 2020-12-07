/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaaplicacion;

/**
 *
 * @author carlos
 */
public class Estudiante extends Persona {

    private double nota;
    private String materia;

    public Estudiante() {
        super();
    }

    public Estudiante(String nombre, int edad, int dni, double nota, String materia) {
        super(nombre, edad, dni);
        this.nota = nota;
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + "- Nota:  " + nota + " - Materia: " + materia;
    }
}
