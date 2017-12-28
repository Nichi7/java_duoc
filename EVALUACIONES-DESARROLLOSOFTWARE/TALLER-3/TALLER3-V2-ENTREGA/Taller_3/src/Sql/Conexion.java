/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author daniela
 */
public class Conexion {

    private static Connection conectar = null;
    private static Conexion conn = null;

    private Conexion() {
        //conexion BD MYSQL
        try {
            String driverUrl = "jdbc:mysql://localhost:3306/botanica";
            conectar = DriverManager.getConnection(driverUrl, "root", "Daniela30/");
            System.out.println("CONECTADO A MYSQL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        if (conn == null) {
            conn = new Conexion();
        }
        return conectar;
    }

}
