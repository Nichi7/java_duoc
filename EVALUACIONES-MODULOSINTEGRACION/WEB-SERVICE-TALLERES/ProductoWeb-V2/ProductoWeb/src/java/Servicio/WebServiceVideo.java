/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import modelo.Categoria;
import modelo.Pelicula;
import sql.Conexion;

/**
 *
 * @author daniela
 */
@Path("/video")
public class WebServiceVideo {
    @GET
    @Path("/pelicula")
    @Produces("application/json")
    /*crea metodo que retorna un objeto de la clase Arraylist con elementos de la pelicula en formato json*/
    public ArrayList<Pelicula> listaPeliculas(){
        /*se crea arraylist con el nombre de pelicula*/
        ArrayList<Pelicula> peliculas = new ArrayList();
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT codigo, precio, categoria, formato4k, nombre FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            //mientras voy recibiendo datos
            while (r.next()) {
               peliculas.add(new Pelicula(r.getInt("codigo"), r.getInt("precio"), r.getInt("categoria"), r.getString("formato4k"), r.getString("nombre")));
            }
            //voy agregando voy agregando al arreglo Categ elementos de la clase categoria, segun constructor 
            //Categoria( int id, String descrpcion)
        } catch (Exception e) {
         System.out.println(e.getMessage());}
        return peliculas;
    }
               
    
    @GET
    @Path("/categoria")
    @Produces("application/json")
    public ArrayList<Categoria> listaCategoria(){
        ArrayList<Categoria> categ = new ArrayList();
        try{
             Connection conexion = Conexion.getConexion();
            String consulta = "SELECT id, descripcion FROM categoria";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            //mientras voy recibiendo datos
            while (r.next()) {
                categ.add(new Categoria(r.getInt("id"), r.getString("descripcion")));
            }
            //voy agregando voy agregando al arreglo Categ elementos de la clase categoria, segun constructor 
            //Categoria( int id, String descrpcion)
            
        }
        catch(Exception e){
         System.out.println(e.getMessage());}
        return categ;
    }
}
