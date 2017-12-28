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
import modelo.Pelota;

/**
 *
 * @author Xberto
 */
public class Registro {
    public String agregar(Pelota p){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM PELOTAS WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Código ya existe";
            String query = "INSERT INTO PELOTAS "
                    + "(CODIGO, NOMBRE, DESCR, TIPO, PESO, DIAMETRO, REBOTE, COLOR, MATERIAL)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCodigo());
            ins.setString(2, p.getNombre());
            ins.setString(3, p.getDescripcion());
            if(p.isTipo())
                ins.setInt(4, 1);
            else
                ins.setInt(4, 0);
            ins.setInt(5, p.getPeso());
            ins.setDouble(6, p.getDiametro());
            if(p.isRebota())
                ins.setInt(7, 1);
            else
                ins.setInt(7, 0);
            ins.setString(8, p.getColor());
            ins.setInt(9, p.getMaterial());
            ins.executeUpdate();
            return "Pelota Ingresada a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    public Pelota buscar(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM PELOTAS WHERE CODIGO =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            if(r.next()){
                Pelota p = new Pelota();
                p.setCodigo(r.getInt("CODIGO"));
                p.setColor(r.getString("COLOR"));
                p.setDescripcion(r.getString("DESCR"));
                p.setDiametro(r.getDouble("DIAMETRO"));
                p.setMaterial(r.getInt("MATERIAL"));
                p.setNombre(r.getString("NOMBRE"));
                p.setPeso(r.getInt("PESO"));
                p.setRebota(r.getInt("REBOTE")==1);
                p.setTipo(r.getInt("TIPO")==1);
                return p;
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
            String consulta = "DELETE FROM PELOTAS WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }
    
    public String actualizar(Pelota p){
        try {
            Connection conexion = Conexion.getConexion();
            
            String query = "UPDATE PELOTAS "
                    + "set NOMBRE=?, DESCR=?, TIPO=?, PESO=?, DIAMETRO=?, REBOTE=?, COLOR=?, MATERIAL=?"
                    + " WHERE CODIGO = ?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setString(1, p.getNombre());
            ins.setString(2, p.getDescripcion());
            if(p.isTipo())
                ins.setInt(3, 1);
            else
                ins.setInt(3, 0);
            ins.setInt(4, p.getPeso());
            ins.setDouble(5, p.getDiametro());
            if(p.isRebota())
                ins.setInt(6, 1);
            else
                ins.setInt(6, 0);
            ins.setString(7, p.getColor());
            ins.setInt(8, p.getMaterial());
            ins.setInt(9, p.getCodigo());
            ins.executeUpdate();
            return "Pelota Actualizada a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
}
