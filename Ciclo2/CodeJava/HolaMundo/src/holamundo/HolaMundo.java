/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;
import java.util.Scanner;
/**
 *
 * @author carlos
 */

public class HolaMundo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        int n = x - y;
        System.out.println(sw(x));
    }
    public static  String sw(int n) {
        String s = "";
        switch(n)
        {
            case 1 :
                s = "Es y";
                break;
            case 2:
                s = "Es x";
                break;
        };
        return s;
    }
    
}
