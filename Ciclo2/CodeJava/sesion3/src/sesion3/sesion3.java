/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion3;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class sesion3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float n = Integer.parseInt(entrada.nextLine());
        float m = Integer.parseInt(entrada.nextLine());
        System.out.println(analisis(n,m));
    }
    
    static Integer analisis(double n, double m){   
        int dias = 1;
        while (m < n && n <= Math.pow(10,18)){
                n = n * 1.02; 
                m = m * 1.03;
                dias ++;    
            }
        return dias;
    }
}
