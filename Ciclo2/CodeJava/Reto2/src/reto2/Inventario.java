/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2;

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

    public Inventario() {
        carros = new HashMap<>();
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
                        codigointerno ++;
                        break;
                    } else if ( comando[1].equals(particular)){
                        Particular nw = new Particular(Integer.parseInt(comando[3]), Integer.parseInt(comando[2]), comando[4], comando[1], comando[5]);
                        Agregar(codigointerno, nw.toString(), carros);
                        codigointerno ++;
                        break;
                    } else{
                            break;
                            }

                case "2":
                    Visualizar(carros);

                    break;
            }

        } while (!comando[0].equals(
                "3"));
    }

    public static void main(String[] args) {
        Inventario a = new Inventario();
        a.procesarComandos();
    }

}
