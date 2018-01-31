/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uml.Persona;


/**
 *
 * @author daniela
 */
//objeto de acceso que haga las transacciones a la base de datos, tabla persona
public class DAOPersona implements Operaciones {
    //creo objeto db para tener acceso a base de datos
    Database db = new Database();

    @Override
    public String insertar(Object obj) {
        //traducir ese objeto a tipo de persona
        Persona p = (Persona)obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into persona values(?,?,?,?)"; //sentencias preparadas, despues se insertan datos
        String respuesta= "";
        try
        {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
            );
            pst = conn.prepareStatement(sql);//le aviso a la base de dato que le enviare cierta consulta sql
            //inserto datos a la consulta
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNombres());
            pst.setString(3, p.getApellidos());
            pst.setInt(4, p.getEdad());
            //ejecutar la consulta antes definida
            int filas = pst.executeUpdate();
            respuesta = "se ingresaron"+filas+"nuevo elementos";
            conn.close();
            
            
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return respuesta;
        
    }

    @Override
    public String eliminar(Object obj) {
      //traducir ese objeto a tipo de persona
        Persona p = (Persona)obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from persona where id=?"; //sentencias preparadas, despues se insertan datos
        String respuesta= "";
        try
        {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
            );
            pst = conn.prepareStatement(sql);//le aviso a la base de dato que le enviare cierta consulta sql
            //inserto datos a la consulta
            pst.setInt(1, p.getId());
            int filas = pst.executeUpdate();
            respuesta = "se eliminaron"+filas+"nuevo elementos";
            conn.close();
            
            
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return respuesta;   
            
    }

    @Override
    public String modificar(Object obj) {
        Persona p = (Persona)obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update persona set nombres=?, apellidos=?, edad=? where id=?"; 
        String respuesta= "";
        try
        {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
            );
            pst = conn.prepareStatement(sql);//le aviso a la base de dato que le enviare cierta consulta sql
            //inserto datos a la consulta
            
            pst.setString(1, p.getNombres());
            pst.setString(2, p.getApellidos());
            pst.setInt(3, p.getEdad());
            pst.setInt(4, p.getId());
            //ejecutar la consulta antes definida
            int filas = pst.executeUpdate();
            respuesta = "se modificaron"+filas+"tantos elementos";
            conn.close();
            } catch (ClassNotFoundException | SQLException e) {
            
        }
        return respuesta;
        
    }
            

    @Override
    public List<Persona> consultar() {
        List<Persona> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        //necesito valor de retorno
        ResultSet rs;
        String sql = "select * from persona";
         try
        {
            //establecimiento de la conexion
        
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
            );
            pst = conn.prepareStatement(sql);
            //ejecutar mi sentencia y retornar el valor a mi variable resulset
            rs = pst.executeQuery();
            while (rs.next()){
                datos.add(new Persona(rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getInt("edad")));
                
            }
            conn.close(); //cierro la conexion
                
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return datos;
       
    }

    @Override
    public List<Persona> filtrar(String campo, String criterio) {
        List<Persona> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        //necesito valor de retorno
        ResultSet rs;
        String sql = "select * from persona where " + campo + " like '%"+criterio+"%';";
         try
        {
            //establecimiento de la conexion
        
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
            );
            pst = conn.prepareStatement(sql);
            //ejecutar mi sentencia y retornar el valor a mi variable resulset
            rs = pst.executeQuery();
            while (rs.next()){
                datos.add(new Persona(rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getInt("edad")));
                
            }
            conn.close(); //cierro la conexion
                
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return datos;
        
    }
    //operaciones insertar, modificar, filtrar, eliminar
    
    
}
