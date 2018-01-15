/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Concepción
 */
public class Conexion2 {
    private static Connection connection = null;
    private static Conexion2 conn=null;
    
    private Conexion2(){
        try {
           String driverUrl="jdbc:mysql://localhost:3306/ventas";
           connection = DriverManager.getConnection(driverUrl, "root","duoc");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion() {
       if(conn==null)
           conn = new Conexion2();
       return connection;
    }   
    
}
