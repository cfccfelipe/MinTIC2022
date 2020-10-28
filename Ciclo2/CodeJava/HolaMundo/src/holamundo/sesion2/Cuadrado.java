/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo.sesion2;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Cuadrado {
    public static void main(String[] args){
        Scanner enteros = new Scanner(System.in);
        double x = Double.parseDouble(enteros.nextLine());
        System.out.println(cuadrado(x));
    }
    public static double cuadrado(double x){
        return x * x;
    }

}
