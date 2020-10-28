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
public class ciclo_while {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int i = 10;
        int x = Integer.parseInt(a.nextLine());
        while (i > x){
            System.out.println(i);
            i-= 1;
        }
    }
    
}

