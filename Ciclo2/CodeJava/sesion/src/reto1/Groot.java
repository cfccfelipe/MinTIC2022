/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Groot {

    //atributos
    public String sentimientos;

    //constructor
    Groot(String sentimientos) {
        this.sentimientos = sentimientos;
    }

    // metodo
    public void capas(int n) {

        String frase1 = "I am";
        String frase2 = "I groot";
        String salida = "";
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                salida = salida + frase1;
 
            }else if (i % 2 == 0) {
                salida = salida + " that " + frase2;

            } else {
                salida = salida + " that " + frase1;
            }
        }
        salida = salida + " it";
        System.out.println(salida);

    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        int n = Integer.parseInt(c.nextLine());
        Groot groot1 = new Groot("Raul");
        groot1.capas(n);
    }
}
