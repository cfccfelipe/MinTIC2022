/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author carlos
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Inventario {

    public HashMap<String, String> carros;
    private int n;
    public int stockcomercial;
    private int stockparticular;
    private int preciocomercial;
    private int precioparticular;
    private int iva;
    private long valorapagar;
    private long totaliva;

    public Inventario() {
        carros = new HashMap<>();
        stockcomercial = 100;
        stockparticular = 100;
        preciocomercial = 40000000;
        precioparticular = 30000000;
        iva = 21;
        valorapagar = 0;
        totaliva = 0;
    }

    public void Agregar(int codigointerno, String vehiculo, HashMap<String, String> carros) {
        String codigo = Integer.toString(codigointerno);
        carros.put(codigo, vehiculo);
    }

    public void Visualizar(HashMap<String, String> carros) {
        String clave;
        Iterator<String> lista = carros.keySet().iterator();
        System.out.println("***Inventario de vehículos***");
        while (lista.hasNext()) {
            clave = lista.next();
            System.out.println(carros.get(clave));
        }

    }

    public void saldoComercial(int saldo) {
        stockcomercial = stockcomercial - saldo;
    }

    public void saldoParticular(int saldo) {
        stockparticular = stockparticular - saldo;
    }

    public void valoraPagar(int cantidadparticular, int cantidadcomercial) {
        int totalvehiculos = cantidadparticular + cantidadcomercial;
        iva = iva - totalvehiculos;
        if (iva < 0) {
            iva = 0;
        } else {
        }
        valorapagar = (cantidadparticular * precioparticular) + (cantidadcomercial * preciocomercial);
        double totalivat = valorapagar * iva / 100;
        totaliva = Math.round(Math.ceil(totalivat));
        valorapagar = valorapagar + totaliva;

    }

    public void procesarComandos() {
        int codigointerno = 0;
        String[] comando;
        Scanner sc = new Scanner(System.in);
        do {
            comando = sc.nextLine().split("&");
            switch (comando[0]) {
                case "1":
                    String comercial = "Comercial";
                    String particular = "Particular";
                    if (comando[1].equals(comercial)) {
                        Comercial nw = new Comercial(Integer.parseInt(comando[3]), Integer.parseInt(comando[2]), comando[4], comando[1], Integer.parseInt(comando[5]));
                        Agregar(codigointerno, nw.toString(), carros);
                        codigointerno++;
                        break;
                    } else if (comando[1].equals(particular)) {
                        Particular nw = new Particular(Integer.parseInt(comando[3]), Integer.parseInt(comando[2]), comando[4], comando[1], comando[5]);
                        Agregar(codigointerno, nw.toString(), carros);
                        codigointerno++;
                        break;
                    } else {
                        break;
                    }

                case "2":
                    Visualizar(carros);
                    break;
                case "3":
                    saldoParticular(Integer.parseInt(comando[2]));
                    saldoComercial(Integer.parseInt(comando[4]));
                    if (stockparticular <= 0 || stockcomercial <= 0) {
                        System.out.println("Lo sentimos no tenemos stock suficiente");
                        stockparticular = stockparticular + Integer.parseInt(comando[2]);
                        stockcomercial = stockcomercial + Integer.parseInt(comando[4]);
                    } else {
                        valoraPagar(Integer.parseInt(comando[2]), Integer.parseInt(comando[4]));
                        System.out.println("CONCESIONARIO UNCAR");
                        System.out.println("UNCAR - UNIVA");
                        System.out.println("NIT: 899.999.063");
                        System.out.println("Cliente: " + comando[5]);
                        System.out.println("Vehículo Cant Precio");
                        System.out.println("Particular x" + comando[2] + " $" + precioparticular);
                        System.out.println("Comercial x" + comando[4] + " $" + preciocomercial);
                        System.out.println("Iva: $" + totaliva);
                        System.out.println("Total: $" + valorapagar);
                        System.out.println("---");
                        iva = 21;

                    }
                    break;
                case "4":
                    System.out.println("Particular: " + stockparticular);
                    System.out.println("Comercial: " + stockcomercial);
                    System.out.println("---");
                    break;
            }

        } while (!comando[0].equals(
                "5"));
    }

    public static void main(String[] args) {
        Inventario a = new Inventario();
        a.procesarComandos();
    }

}
