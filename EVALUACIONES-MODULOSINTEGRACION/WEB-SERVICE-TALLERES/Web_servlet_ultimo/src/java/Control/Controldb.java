/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Concepción
 */
public class Controldb {
    private static Connection connection = null;
    private static Controldb conn=null;
    
    public Controldb(){
        try {
           String driverUrl="jdbc:mysql://localhost:3306/video";
           connection = DriverManager.getConnection(driverUrl, "root","duoc");
            System.out.println("conectado");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion() {
       if(conn==null)
           conn = new Controldb();
       return connection;
    }
    
}
