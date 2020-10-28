/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion4;
import java.util.Arrays;
/**
 *
 * @author carlos
 */
public class arreglos {
    public static void main(String[] args) {
        String [] palabra = {"queso", "azucar"};
        System.out.println(palabra[1]);
        // Creando un arreglo de 5 posiciones
        String[] nombre = new String[5];
        nombre[0] = "Carlos";
        nombre[1] = "Ricardo";
        System.out.println(nombre[1]);
        System.out.println(Arrays.toString(nombre));
        System.out.println(nombre.length);

    }
    
}
