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
 * @author Xberto
 */
public class Conexion {   
    private static Connection connection = null;
    private static Conexion conn=null;
    
    private Conexion(){
        try {
           String driverUrl="jdbc:oracle:thin:@cpc-pm-01-01.aws.smartcloud.cl:1521:XE";
           connection = DriverManager.getConnection(driverUrl, "usuario10","usuario10");
            System.out.println("CONECTADO A ORACLE");
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
