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
public class localidades {

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

    public Vector<localidades> mostrarLocalidades(Integer idMunicipio) 
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        Vector<localidades> datos = new Vector<localidades>();
        localidades dat = null;

        try {
            String sql = "SELECT * FROM t_localidad WHERE t_municipio_id_municipio="+idMunicipio;
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            dat = new localidades();
            //colocar la primera opcion
            dat.setId(0);
            dat.setNombre("Seleccione Localidad");
            datos.add(dat);

            while (rs.next()) 
            {
                dat = new localidades();
                dat.setId(rs.getInt("id_localidad"));
                dat.setNombre(rs.getString("localidad"));
                datos.add(dat);

            }
            rs.close();
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return datos;
    }
}
