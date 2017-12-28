/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author daniela
 */
public class ConexionDB {
    //crea método conexion

    public static void connect() {
        String url = "jdbc:mysql://localhost:3306/db1";
        //String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "root";
        String pass = "Daniela30/";
        System.out.println("Proceso en Coneccion...");

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            {
                System.out.println("Base de Datos Conectada!!");
            }
            //insertar datos a BD
            System.out.println("Insertar Registro");
            Statement s = connection.createStatement();
            /*String query1 = "INSERT INTO tabla1 (usuario,clave,fecha) value (\"Ines\",\"2014\",NOW())";
            s.execute(query1);*/
            //Finaliza proceso
            //sentencia mostrar
           /* String query2 = "SELECT *FROM tabla1";
            ResultSet r = s.executeQuery(query2); //executeQuery retorna un dato
            while (r.next()) {//mientras ResultSet retorne algo se ejecuta
                System.out.println(r.getObject("id") + "-" + r.getObject("usuario") + "-" + r.getObject("clave") + "-" + r.getObject("fecha"));}*/
//sentencia eliminar
               /*String query3 = "DELETE FROM tabla1 WHERE usuario ='Ines'";
                s.execute(query3);
                System.out.println("Eliminación exitosa");*/
               String query4 = "UPDATE tabla1 SET clave=999 WHERE clave=2014";
               s.execute(query4);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
            connect();
        }

    }

}
