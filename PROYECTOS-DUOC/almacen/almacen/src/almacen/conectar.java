/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Xberto
 */
public class conectar {
    Connection conectar = null;
    
    public Connection conexion(){
        try{
            String driverClassName = "oracle.jdbc.driver.OracleDriver";
            String driverUrl="jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName(driverClassName);
            this.conectar = DriverManager.getConnection(driverUrl,"Almacen","almacen");
        }   
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conectar;
    }
    
    
    
}
