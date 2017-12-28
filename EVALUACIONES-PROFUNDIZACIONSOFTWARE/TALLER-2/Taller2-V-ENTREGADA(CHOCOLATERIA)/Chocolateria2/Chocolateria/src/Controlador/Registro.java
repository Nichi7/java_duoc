/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sql.Conexion;
import Modelo.Chocolate;
import Modelo.Ventas;
import java.util.ArrayList;

/**
 *
 * @author Concepción
 */
public class Registro {
     public String agregar(Chocolate c){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM chocolate WHERE CODIGO =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, c.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Código ya existe";
            String query = "INSERT INTO chocolate "
                    + "(CODIGO, NOMBRE, DESCRIP, PRECIO, CANTIDAD, TIPO, TIPO_C, MARCA, AZUCAR)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, c.getCodigo());
            ins.setString(2, c.getNombre());
            ins.setString(3, c.getDescripcion());
            ins.setInt(4, c.getPrecio());
            ins.setInt(5, c.getCantidad());
            ins.setString(6, c.getTipo());
            ins.setString(7, c.getTipo_choc());
            ins.setString(8, c.getMarca());
            if(c.isAzucar())
                ins.setInt(9, 1);
            else
                ins.setInt(9, 0);
            ins.executeUpdate();
            return "Chocolate Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    public Chocolate buscar(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM chocolate WHERE CODIGO =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if(r.next()){
                //crea objeto pelota
                Chocolate c = new Chocolate();
                c.setCodigo(r.getInt("CODIGO"));
                c.setNombre(r.getString("NOMBRE"));
                c.setDescripcion(r.getString("DESCRIP"));
                c.setPrecio(r.getInt("PRECIO"));
                c.setCantidad(r.getInt("CANTIDAD"));
                c.setTipo(r.getString("TIPO"));
                c.setTipo_choc(r.getString("TIPO_C"));
                c.setMarca(r.getString("MARCA"));
                c.setAzucar(r.getInt("AZUCAR")==1);//booleano
                return c;
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
            String consulta = "DELETE FROM chocolate WHERE CODIGO =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }
    
    public String actualizar(Chocolate c){
        try {
            Connection conexion = Conexion.getConexion();
            
            String query = "UPDATE chocolate "
                    + "set NOMBRE=?, DESCRIP=?, PRECIO=?, CANTIDAD=?, TIPO=?, TIPO_C=?, MARCA=?, AZUCAR=?"
                    + " WHERE CODIGO = ?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setString(1, c.getNombre());
            ins.setString(2, c.getDescripcion());
            ins.setInt(3, c.getPrecio());
            ins.setInt(4, c.getCantidad());
            ins.setString(5, c.getTipo());
            ins.setString(6, c.getTipo_choc());
            ins.setString(7, c.getMarca());
            if(c.isAzucar())
                ins.setInt(8, 1);
            else
                ins.setInt(8, 0);
            ins.setInt(9,c.getCodigo());
            ins.executeUpdate();
            return "Actualización a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
        public Ventas ventas(){
        Ventas v = new Ventas();
        int ventas = 0;
        int cantidad = 0;
        
            try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT CANTIDAD,PRECIO  FROM chocolate";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
                cantidad = cantidad+r.getInt("CANTIDAD");
                ventas = (ventas+(r.getInt("PRECIO")*r.getInt("CANTIDAD")));
            }
            v.setCantidad(cantidad);
            v.setVentas(ventas);
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return v;    
    }
        
         //crea arraylist   
      /*private ArrayList<Ventas> show  = new ArrayList<>();
        
        public ArrayList<Ventas> showchocolate(){
            Ventas v = new Ventas();
           int cantidad = 0;
           int ventas =0;*/
            
           /* for(Chocolate c: show){
            if(p.equals(t))
                return false;
        }
            return this.productos.add(p);*/
        /*try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT CANTIDAD, PRECIO FROM chocolate";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
                cantidad = r.getInt("CANTIDAD");
                ventas = r.getInt("PRECIO");
                
                show.add(new Ventas(v.setVentas(),v.setCantidad()));
            }
            
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return v;  
        }*/

}
