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
public class Carrito {

    private Articulo[] articulos;
    private int n;

    public Carrito() {
        articulos = new Articulo[10000];
    }

    public void agregarArticulo(Articulo a) {
        articulos[n] = a;
        n++;
    }

    public String factura(String c) {
        //variables para hallar precio y valor a pagar
        double total = 0;
        double valorapagar = 0;
        String productos = "";
        //for para sumar los precios unitarios de cada producto
        for (int i = 0; i < n; i++) {
            int preciot = articulos[i].getPreciou() * articulos[i].getCantidad();
            valorapagar += preciot;
            //convirtiendo el array en String
            productos = productos + articulos[i].getProducto() + " x" + articulos[i].getCantidad() + " $" + preciot + "\n";

        }
        //if  para agregarle descuento cuando exista
        if (valorapagar > 150000 && valorapagar <= 300000) {
            total = valorapagar * 90 / 100;
        } else if (valorapagar > 300000 && valorapagar <= 700000) {
            total = valorapagar * 85 / 100;
        } else if (valorapagar > 700000) {
            total = valorapagar * 80 / 100;
        } else {
            total = valorapagar;
        }
        //Ceil para aproximar
        total = Math.ceil(total); 
        double descuento = valorapagar - total;
        //Dando formato entero al total y el descuento
        int descuentof = (int) descuento;
        int total1 = (int) total;
        //Imprimiendo factura
        String resultado = "Centro Comercial Unaleño" + "\n" + "Compra más y Gasta Menos" + "\n"
                + "NIT: 899.999.063" + "\n" + "Cliente: " + c + "\n" + "Art Cant Precio" + "\n" + productos
                + "Total: $" + total1 + "\n" + "En esta compra tu descuento fue $" + descuentof + "\n" + "Gracias por tu compra" + "\n" + "---";

        return resultado;
    }

    public void procesarComandos() {
        String[] comando;
        String facturas = "";
        int i = 0;
        Scanner sc = new Scanner(System.in);
        do {
            comando = sc.nextLine().split("&");
            switch (comando[0]) {
                case "1":
                    agregarArticulo(new Articulo(comando[1], Integer.parseInt(comando[2]), Integer.parseInt(comando[3])));
                    break;
                case "2":
                    String cliente = comando[1];
                    facturas = facturas + "\n" + factura(cliente);
                    i++;
                    n = 0;
                    break;
            }

        } while (!comando[0].equals(
                "3"));
        System.out.println(facturas);
    }

    public static void main(String[] args) {
        Carrito a = new Carrito();
        a.procesarComandos();
    }
}
