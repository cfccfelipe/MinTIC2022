/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion4;

/**
 *
 * @author carlos
 */
public class split {

    public static void main(String[] args) {
        String s = "Gandalf 3000 1.68";
        String[] line = s.split(" ");
        String nombre = line[0];
        int edad = Integer.parseInt(line[1]);
        double estatura = Double.parseDouble(line[2]);
        System.out.println("nombre: " + nombre);
        System.out.println("edad: " + edad);
        System.out.println("estatura: " + estatura + "cm");
    }

}
