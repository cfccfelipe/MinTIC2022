/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclo;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class ciclo_array {

    public static int[] leerArreglo(Scanner sc,
            int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(sc.nextLine());
        }
        return x;
    }

    public static void escribirArregloalcubo(int[] x) {
        for (int i = 0; i < x.length; i++) {
            int [] y = new int[x.length];
            y[i] =  x[i] * x[i] * x[i];
            System.out.print(y[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner arr = new Scanner(System.in);
        int[] x = new int[5];
        x = leerArreglo(arr, x);
        escribirArregloalcubo(x);

    }

}
