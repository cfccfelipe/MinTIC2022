/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javafx.scene.input.KeyCode;

/**
 *
 * @author carlos
 */
public class Perro {
// Atributos

    public int edad;
    public String nombre;
    public String colorOjos;
// Constructor

    Perro(int edad, String nombre, String colorOjos) {
        this.edad = edad;
        this.nombre = nombre;
        this.colorOjos = colorOjos;
    }
// Metodos

    public void ladrar() {
        System.out.println("Guau Guau");
    }

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }

    public static void main(String[] args) {
        Perro miPerro1 = new Perro(5, "Toby", "Azul");
        Perro miPerro2 = new Perro(7, "Vainilla", "Negro");
        Perro miPerro3 = new Perro(5, "Bony", "Amarillo");
        System.out.println(miPerro1.edad);
        miPerro1.ladrar();
    }
}
