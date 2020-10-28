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
public class SeleccionFutbol {

    //atributos
    public String nombre;
    private int edad;
    private int id;
    private double salario;
// constructor vacio
    public SeleccionFutbol(){
    }
    //constructor
    public SeleccionFutbol(String nombre, int edad, int id, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.salario = salario;
    }

    //metodos
    public void Concentrar() {
        System.out.println(nombre + " Concentrado");
    }

    public void Viajar() {
        System.out.println(nombre + " Viajar");
    }

}
