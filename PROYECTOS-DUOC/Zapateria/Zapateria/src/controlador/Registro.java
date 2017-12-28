/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sql.Conexion;
import modelo.Zapato;

/**
 *
 * @author Xberto
 */
public class Registro {
    public String agregar(Zapato p){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM zapato WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Código ya existe";
            String query = "INSERT INTO zapato "
                    + "(codigo, nombre,descr,tipo,precio,stock,numero,color,cantidad,genero)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCodigo());
            ins.setString(2, p.getNombre());
            ins.setString(3, p.getDescripcion());
            ins.setString(4, p.getTipo());
            ins.setInt(5, p.getPrecio());
            if(p.isStock())
                ins.setInt(6, 1);
            else
                ins.setInt(6, 0);
            ins.setInt(7, p.getNumero());
            ins.setString(8, p.getColor());
            ins.setInt(9, p.getCantidad());
            if(p.isSexo())
                ins.setInt(10, 1);
            else
                ins.setInt(10, 0);
            ins.executeUpdate();
            return "Zapato Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    
    public void actualizar(Zapato p){
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE zapato "
                    + " SET nombre=?,descr=?,tipo=?,precio=?,stock=?,numero=?,color=?,cantidad=?,genero=?"
                    + " WHERE codigo=?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setString(1, p.getNombre());
            ins.setString(2, p.getDescripcion());
            ins.setString(3, p.getTipo());
            ins.setInt(4, p.getPrecio());
            if(p.isStock())
                ins.setInt(5, 1);
            else
                ins.setInt(5, 0);
            ins.setInt(6, p.getNumero());
            ins.setString(7, p.getColor());
            ins.setInt(8, p.getCantidad());
            if(p.isSexo())
                ins.setInt(9, 1);
            else
                ins.setInt(9, 0);
            ins.setInt(10, p.getCodigo());
            
            ins.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
    }
    
    
    public Zapato buscarPorCodigo(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM zapato WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
           
            ResultSet r = qry.executeQuery();
            if(r.next()){
                Zapato z = new Zapato(
                        r.getInt("codigo"),
                        r.getString("nombre"),
                        r.getString("descr"),
                        r.getInt("precio"),
                        r.getInt("stock")==1,
                        r.getInt("cantidad"),
                        r.getString("color"),
                        r.getString("tipo"),
                        r.getInt("genero")==1,
                        r.getInt("numero")
                );
                return z;
            }else
                return null;
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return null;    
    }
    public void eliminar(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM zapato WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }
}
