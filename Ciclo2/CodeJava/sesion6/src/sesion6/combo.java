/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion6;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class combo {

    public static String combo(double precio1, double precio2, double precio3, double preciod) {
        String resultado = "";
        if ((precio1 + precio2 + precio3) < preciod) {
            resultado = "por separado";
        } else {
            resultado = "combo";
        }
        return resultado;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double precioUno = Double.parseDouble(sc.nextLine());
        double precioDos = Double.parseDouble(sc.nextLine());
        double precioTres = Double.parseDouble(sc.nextLine());
        double precioDescuento = Double.parseDouble(sc.nextLine());
        System.out.println("Debe comprar " + combo(precioUno, precioDos, precioTres, precioDescuento));
    }

}


