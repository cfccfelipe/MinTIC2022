/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion6;

/**
 *
 * @author carlos
 */
public class Articulo {

    //Atributos
    public String producto;
    public int cantidad;
    public int preciou;

    //Constructor
    public Articulo(String producto, int cantidad, int preciou) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciou = preciou;
    }

    //Metodos
    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPreciou() {
        return preciou;
    }

    @Override
    public String toString() {
        return producto + " " + cantidad + " $" + preciou;
    }
}
