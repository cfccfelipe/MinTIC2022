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
public class Profesor extends Persona {
    
    private String profesion;
    private String asignatura;
    
    public Profesor(){
    super();
    }
    
    public Profesor(String nombre, int edad, int dni, String profesion, String asignatura){
        super(nombre, edad, dni);
        this.profesion = profesion;
        this.asignatura = asignatura;
    }
    
    @Override
    public String toString() {
        
        return super.toString() + "- Profesion:  " + profesion + " - Asignatura: " + asignatura;
    } 
}
