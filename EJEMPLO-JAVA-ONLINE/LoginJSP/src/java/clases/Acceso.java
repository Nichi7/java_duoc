/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;

/**
 *
 * @author daniela
 */
//metodo para validar al usuario que se quiere logear
public class Acceso {

    Database db = new Database();
    String sql = "";
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    //contructor vacio

    public Acceso() {
    }

    //crea metodo validar
    public int validar(String usuario, String contra) {
        int nivel = 0;
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getContra());
            sql = "select nivel from users where username='" + usuario + "' and pass='" + contra + "';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                nivel = rs.getInt(1); //se coloca indice
            }
            con.close();
            rs.close();

            return nivel; //retorna el nivel de la persona
            
        } catch (ClassNotFoundException | SQLException e) {

            return nivel;
        }
    }

}
