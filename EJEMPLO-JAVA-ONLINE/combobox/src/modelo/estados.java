/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author daniela
 */
public class estados {

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String toString() {
        return this.nombre;
    }
    //agregar los valores al combobox      

    public Vector<estados> mostrarEstados() 
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        Vector<estados> datos = new Vector<estados>();
        estados dat = null;

        try {
            String sql = "SELECT * FROM t_estado";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            dat = new estados();
            //colocar la primera opcion
            dat.setId(0);
            dat.setNombre("Seleccione Estado");
            datos.add(dat);

            while (rs.next()) 
            {
                dat = new estados();
                dat.setId(rs.getInt("id_estado"));
                dat.setNombre(rs.getString("estado"));
                datos.add(dat);

            }
            rs.close();
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return datos;
    }
}
