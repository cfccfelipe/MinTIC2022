/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaaplicacion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Curso {

    private ArrayList<Persona> p;

    public Curso() {
        p = new ArrayList<>();
    }

    public void Agregar(Persona p1) {
        p.add(p1);
    }

    public void Imprimir() {
        for (Persona a : p) {
            a.toString();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        String [] cadena= sc.nextLine().split("&");
        Curso a = new Curso();
        
C        while(!cadena[0].equals("3")){
            if(cadena[0].equals("1")){
                if(cadena[1].equals("Estudiante")){
                    a.Agregar(new Estudiante(cadena[2], Integer.parseInt(cadena[3]), Integer.parseInt(cadena[4]), Double.parseDouble(cadena[5]), cadena[6]));
                }else {
                    a.Agregar(new Profesor(cadena[2], Integer.parseInt(cadena[3]), Integer.parseInt(cadena[4]), cadena[5], cadena[6]));
                }
            }else {
                a.Imprimir();
            }
        }
        

    }

}
