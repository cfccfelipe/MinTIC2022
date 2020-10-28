/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class extraernombres {

    public static String leer(Scanner sc) {
        String y = sc.nextLine();
        String[] line = y.split("\\.");
        String salida = line[1];
        return salida;
    }

    public static void main(String[] args) {
        Scanner arr = new Scanner(System.in);
        int n = Integer.parseInt(arr.nextLine());
        String[] x = new String[n];
        for (int i = 0; i < n; i++) {
            x[i] = leer(arr);
        }
        for (int j = 0; j < n; j++) {
            System.out.println(x[j]);
    }
    }
}
