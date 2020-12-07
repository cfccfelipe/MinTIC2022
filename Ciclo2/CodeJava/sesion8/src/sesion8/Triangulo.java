/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion8;

/**
 *
 * @author carlos
 */
public class Triangulo implements Operaciones_Figuras {

    //atributos
    private double lado1;
    private double lado2;
    private double lado3;
//constructor vacio

    public Triangulo() {

    }

    //constructor 
    public Triangulo(double l1, double l2, double l3) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;

    }

    public double perimetro() {

        return this.lado1 + this.lado2 + this.lado3;
    }

    public double area() {
        double s = this.perimetro() / 2;
        return (Math.sqrt((s * (s - this.lado1) * (s - this.lado2) * (s - this.lado3))));
    }

}
