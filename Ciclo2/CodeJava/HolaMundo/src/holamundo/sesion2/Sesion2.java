/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo.sesion2;
import java.util.Scanner;
/**
}author carlos
 */
public class Sesion2 {
    public static void main(String[] args){
    Scanner enteros = new Scanner(System.in);
    int a = Integer.parseInt(enteros.nextLine());
    int b = Integer.parseInt(enteros.nextLine());
    int c = Integer.parseInt(enteros.nextLine());
    int d = Integer.parseInt(enteros.nextLine());
    System.out.println(validacion(a,b,c,d));
    }
    public static String validacion(int a, int b, int c, int d){
        String valor;
        if((b > c) && (d > a) && (((c + d) > (a + b))) && (c > 0) && (d > 0) && ((a % 2 == 0))) {
        valor = ("Valores aceptados");
    } else {
            valor = ("Valores no aceptados");
            }
    return valor;
    }
}
