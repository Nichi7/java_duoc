/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import negocio.Producto;
import servicio.Conexion;



/**
 *
 * @author Jazna
 */
public class Registroproducto {
//se declara un atributo de tipo producto llamado p
    public String agregar(Producto p){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT 1 FROM producto WHERE pr_id =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getId());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Producto ya existe";
            String query = "INSERT INTO producto "
                    + "(pr_id, pr_nombre, pr_moneda, pr_valormoneda)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getId());
            ins.setString(2, p.getNombre());
            ins.setString(3, p.getMoneda());
            ins.setFloat(4, p.getValorMoneda());  
            ins.executeUpdate();
            return "Producto Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
 public ArrayList<Producto> listar(){
        //se crea arraylis de productos llamdo d
    ArrayList<Producto> d = new ArrayList();
    //inicializamos
    Producto p =null;
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM producto";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
                //crear nuevo producto
                p = new Producto();
                p.setId(r.getInt("pr_id"));
                p.setNombre(r.getString("pr_nombre"));
                p.setMoneda(r.getString("pr_moneda"));
                p.setValorMoneda(r.getInt("pr_valormoneda"));
                d.add(p);
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return d;
    
    }
   
}
