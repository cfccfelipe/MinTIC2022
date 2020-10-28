/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author carlos
 */
public class competencia {

    public static int[] opiniones(Scanner sc,
            int[] x, int n){
        String y = sc.nextLine();
        String[] line = y.split(" ");
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(line[i]);
        }
        return x;    
        }


    public static String revisar(int[] x, int n) {
        String resultado = "";
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 0){
                a ++;
            }
            else if(x[i] == 1){
                b ++;
            }
            }
        if (b > 0){
            resultado = "DIFICIL";
                    }
        else{
            resultado = "FACIL";
        }
    return resultado;
    }
    public static void main(String[] args) {
        Scanner arr = new Scanner(System.in);
        int n = Integer.parseInt(arr.nextLine());
        int[] x = new int[n];
        x = opiniones(arr, x, n);
        System.out.println(revisar(x,n));

    }
}
