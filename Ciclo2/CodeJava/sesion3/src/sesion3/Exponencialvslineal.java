/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3;

/**
 *
 * @author carlos
 */
public class Exponencialvslineal {
    public static void main(String[] args) {

        int i = 2; // inicializa a i en 2
        int j = 25; // inicializa a j en 25
        while (i < j) { // mientras i sea menor a j
// imprime los valores de i y j 
            System.out.println(i + ", " + j);
            i = i * 2; // i se multíplica por 2 en cada paso
            j = j + 10; // se incrementa de 10 en 10
        }
// se ejecuta al terminar el ciclo
        System.out.println("the end.");
        System.out.println(i + ", " + j);// valores finales de i y j
        //organizar alt shilf f

    }
}
