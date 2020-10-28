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
public class area1 {

    public static void main(String[] args){
        Scanner entradas = new Scanner(System.in);
        double r = Double.parseDouble(entradas.nextLine());
        double h = Double.parseDouble(entradas.nextLine());
        double r2 = Double.parseDouble(entradas.nextLine());
        double ac = circulo(r);
        double at = triangulo(r2,h);
        double a = ac + at;
        System.out.println(a);
        
    }
        
    public static double circulo(double radio){
        return Math.PI * Math.pow(radio, 2);
        }
    public static double triangulo(double radio, double altura){
        return (Math.PI * radio * altura) + (Math.PI * Math.pow(radio, 2));
        }
}
