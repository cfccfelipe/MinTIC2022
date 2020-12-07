/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacion;

import java.util.Scanner;
import javax.lang.model.SourceVersion;

public class Main {

   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       int array[] = new int[20];
       int option;
       int memory;

       System.out.println("Bienvenido a la asignación de memoria RAM, seleccione una opción: \n 1- Llenar vector" +
               "\n 2- Asignar memoria \n 3- Ver valores del vector \n 4- Salir");
       option = scanner.nextInt();

       while (option != 4) {
           switch (option) {
               case 1:
                   generateArray(array);
                   System.out.println("Vector llenado exitosamente");
                   break;
               case 2:
                   System.out.println("Digite la cantidad de memoria requerida");
                   memory = scanner.nextInt();
                   assignMemory(array, memory);
                   break;
               case 3:
                   printArray(array);
                   break;
               default:
                   System.out.println("Opción inválida");
                   break;
           }
           System.out.println("Bienvenido a la asignación de memoria RAM, seleccione una opción: \n 1- Llenar vector" +
                   "\n 2- Asignar memoria \n 3- Ver valores del vector \n 4- Salir");
           option = scanner.nextInt();
       }


   }

   private static void assignMemory(int[] array, int memory) {
       int aux = 0;
       int sum = 0;
       boolean assigned = false;
       String positions = " ";
       for (int j = 0; j < array.length; j++) {
           if (array[j] == 0) {
               aux = j;
           }

       }
       for (int i = aux; i < array.length; i++) {
           if (array[i] >= memory) {
               System.out.println("El valor solicitado es: " + memory);
               System.out.println("El valor del vector es: " + array[i]);
               System.out.println("La fragmentación interna: " + (array[i] - memory));
               System.out.println("La posición del vector es: " + i);
               array[i] = 0;
               assigned = true;
               break;
           }
           if (i == 19) {
               for (int j = 0; j < array.length; j++) {
                   if (array[j] >= memory) {
                       System.out.println("El valor solicitado es: " + memory);
                       System.out.println("El valor del vector es: " + array[j]);
                       System.out.println("La fragmentación interna: " + (array[j] - memory));
                       System.out.println("La posición del vector es: " + j);
                       array[j] = 0;
                       assigned = true;
                       break;
                   }
                   if (j == 19) {
                       for (int l = 0; l < array.length; l++) {
                           if (sum < memory && array[l] != 0
) {
                               sum = sum + array[l];
                               positions = positions + " " + l;
                               array[l] = 0;
                           }
                           if (sum >= memory) {
                               System.out.println("El valor solicitado es: " + memory);
                               System.out.println("El valor de los vectores es : " + sum);
                               System.out.println("La fragmentación interna: " + (sum - memory));
                               System.out.println("Las posiciones utilizadas fueron:  " + positions);
                               assigned = true;
                               break;
                           }
                       }
                   }
               }

           }
       }
       if(!assigned){
           System.out.println("Memoria insuficiente");
       }
   }

   private static void generateArray(int[] array) {
       for (int i = 0; i < array.length; i++) {
           array[i] = (int) (Math.random() * (50 - 10 + 1) + 10);
       }

   }

   private static void printArray(int[] array) {
       for (int i = 0; i < array.length; i++) {
           if (i == 19) {
               System.out.println(array[i] + " ");
           } else {
               System.out.print(array[i] + " - ");
           }

       }

   }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

}






