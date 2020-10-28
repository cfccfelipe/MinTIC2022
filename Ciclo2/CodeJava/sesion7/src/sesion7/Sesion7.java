/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion7;

/**
 *
 * @author carlos
 */
public class Sesion7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador messi = new Jugador("Messi",30,2020,1,"Delantero", 5);
        Entrenador bolillo = new Entrenador("Bolillo",10,2,500,"Africano", 5);
        Medico genaro = new Medico("Genaro",50,3,1000,"Fisioterapia", "Maculino");
        
        messi.Concentrar();
        bolillo.Viajar();
        genaro.Concentrar();
        System.out.println(messi.nombre);
      
    }
    
}
