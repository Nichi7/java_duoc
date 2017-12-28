/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Concepción
 */
public class Conexion {   
    private static Connection connection = null;
    private static Conexion conn=null;
    
    private Conexion(){
        try {
           String driverUrl="jdbc:mysql://localhost:3306/examen";
           connection = DriverManager.getConnection(driverUrl, "root","");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion() {
       if(conn==null)
           conn = new Conexion();
       return connection;
    }
}
