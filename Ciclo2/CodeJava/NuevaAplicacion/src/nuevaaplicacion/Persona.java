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
public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    
    public Persona(){

    }
    public Persona (String nombre, int edad, int dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
  @Override
    public String toString() {
        return ("\t"+ "Nombre:  " + nombre + " - Edad: " + edad + "\n" + "\t"+ "DNI: " + dni);
    }  
}
