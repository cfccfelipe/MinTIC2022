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
    public abstract class Vehiculo {

        public int velocidadmaxima;
        public int cantidadpasajeros;
        public String placa;
        public String tipo;

        public Vehiculo(int velo, int pas, String placa, String tipo) {
            this.velocidadmaxima = velo;
            this.cantidadpasajeros = pas;
            this.placa = placa;
            this.tipo = tipo;
        }

    }
