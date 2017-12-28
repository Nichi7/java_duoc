/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Semilla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Sql.Conexion;

/**
 *
 * @author Concepción
 */
public class RegistroSemillas {

    //crea método agregar
    public String agregar(Semilla s) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM semilla WHERE sm_id =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, s.getCodigo());
            ResultSet r = qry.executeQuery();
            if (r.next()) {
                return "Código ya existe";
            }
            String query = "INSERT INTO semilla "
                    + "(sm_id, sm_nombre, sm_precio, sm_tipo)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, s.getCodigo());
            ins.setString(2, s.getNombre());
            ins.setInt(3, s.getPrecio());
            ins.setString(4, s.getTipo());
            ins.executeUpdate();
            return "Semilla Ingresada a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }

    public void eliminar(int codigo) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM semilla WHERE sm_id =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public Semilla buscar(int codigo) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM semilla WHERE sm_id =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if (r.next()) {
                //crea objeto pelota
                Semilla s = new Semilla();
                s.setCodigo(r.getInt("sm_id"));
                s.setNombre(r.getString("sm_nombre"));
                s.setPrecio(r.getInt("sm_precio"));
                s.setTipo(r.getString("sm_tipo"));
                
                
                return s;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

