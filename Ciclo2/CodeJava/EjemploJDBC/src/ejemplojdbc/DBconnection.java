/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojdbc;
import java.sql.*;
/**
 *
 * @author carlos
 */
public class DBconnection {
    final static String USER ="root";
    final static String PASS = "root";
    final static String URL = "jdbc:mysql://localhost:3306/museopresentacion?serverTimezone=UTC&useSSL=false";
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(URL,USER,PASS);
        
    }
    

}
