/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author daniela
 */
public class Registro {
    public ArrayList<Categoria> getCategoria(){
        ArrayList<Categoria> Categ = new ArrayList();
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT id, descripcion FROM categoria";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next())
                Categ.add(new Categoria(r.getInt("id"),r.getString("descripcion")));
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return Categ;    
    }
    public String agregar(Pelicula p){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Código ya existe";
            String query = "INSERT INTO pelicula "
                    + "(codigo, precio, categoria , formato4k, nombre)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCodigo());
            ins.setInt(2, p.getPrecio());
            ins.setInt(3, p.getCategoria());
            ins.setString(4,p.getFormato4k());
            ins.setString(5, p.getNombre());
            
            ins.executeUpdate();
            return "Película Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    public Pelicula buscar(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if(r.next()){
                //crea objeto pelota
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                p.setFormato4k(r.getString("formato4k"));
                p.setPrecio(r.getInt("precio"));
                p.setCategoria(r.getInt("categoria"));
                
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
            String consulta = "DELETE FROM pelicula WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }
    //Actualiza los datos de una pelicula a traves del codigo
    public String actualizar(Pelicula p){
        try {
            Connection conexion = Conexion.getConexion();
            
            String query = "UPDATE pelicula "
                    + "set precio=?, categoria=?, formato4k=?, nombre=?"
                    + " WHERE codigo = ?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getPrecio());
            ins.setInt(2, p.getCategoria());
            ins.setString(3, p.getFormato4k());
            ins.setString(4, p.getNombre());
            ins.setInt(5, p.getCodigo());
            ins.executeUpdate();
            return "Actualización a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    //Inserta una nueva catetegoria a la tabla categoria 
    public String agregar1(Categoria c){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM categoria WHERE id =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, c.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Código ya existe";
            String query = "INSERT INTO categoria "
                    + "(id, descripcion)"
                    + " VALUES (?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, c.getCodigo());
            ins.setString(2, c.getDescrip());
            ins.executeUpdate();
            return "Categoria Ingresada a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    //Consulta una pelicula a traves del nombre de esta
    
     public Pelicula buscar1(String nombre){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula WHERE nombre =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setString(1, nombre);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if(r.next()){
                //crea objeto pelota
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                p.setFormato4k(r.getString("formato4k"));
                p.setPrecio(r.getInt("precio"));
                p.setCategoria(r.getInt("categoria"));
                
                return p;
            }else
                return null;
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return null;    
    }
     //Consulta una pelicula a partir de la descripción de la categoria de la pelicula
    public Pelicula buscar2(String descripcion){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT codigo, nombre, formato4k, precio, categoria, id, descripcion"
                    + " FROM pelicula INNER JOIN categoria ON pelicula.categoria=categoria.id"
                    + " WHERE descripcion=?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setString(1,descripcion);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if(r.next()){
                //crea objeto pelota
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                p.setFormato4k(r.getString("formato4k"));
                p.setPrecio(r.getInt("precio"));
                p.setCategoria(r.getInt("categoria"));

                return p;
            }else
                return null;
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return null;
    }
    //Actualiza una categoria nueva a partir del codigo
    public String actualizar2(Pelicula p){
        try {
            Connection conexion = Conexion.getConexion();

            String query = "UPDATE pelicula"
                    + " set categoria=?"
                    + " WHERE codigo = ?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCategoria());
            ins.setInt(2, p.getCodigo());
            ins.executeUpdate();
            return "Actualización a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }


}
