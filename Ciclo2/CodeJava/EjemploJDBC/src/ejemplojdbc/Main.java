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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection connection = DBconnection.getConnection();

        if (connection != null) {
            System.out.println("Conectado a MYSQL");
        }
        //Permite ejecutar consultas estaticas de SQL
        Statement st = connection.createStatement();

        //Consulta que vamos a realizar
        String query = "SELECT * FROM Museo";

        //Objeto para almacenar el resultado de la consulta
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Nombre del museo: " + rs.getString("mus_nombre") + " Id del museo: " + rs.getInt("museoid"));
        }

        String insert = "INSERT INTO Museo VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setInt(1, 104);
        ps.setString(2, "Manizales");
        //ps.executeUpdate();

        String update= "UPDATE museo SET museoid =?, mus_nombre = ? WHERE museoid = ?";
        PreparedStatement ps2 = connection.prepareStatement(update);
        ps2.setInt(1, 108);
        ps2.setString(2, "Japon");
        ps2.setInt(3, 107);
        //ps2.executeUpdate();
        if (ps2.executeUpdate() > 0){
            System.out.println("Registro actualizado");
        }

    }

}
