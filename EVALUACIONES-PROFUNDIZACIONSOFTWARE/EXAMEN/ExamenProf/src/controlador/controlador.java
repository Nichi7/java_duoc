/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.Depto;
import modelo.Empleado;
import sql.Conexion;

/**
 *
 * @author Concepción
 */
public class controlador {
    
    public ArrayList<Depto> getDeptos(){
        ArrayList<Depto> deptos = new ArrayList();
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT codigo, nombre FROM departamento";
            //PreparedStatement qry = conexion.prepareStatement(consulta);
            
            ResultSet r = conexion.prepareCall(consulta).executeQuery();
            while(r.next())
                deptos.add(new Depto(r.getInt("codigo"),r.getString("nombre")));
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return deptos;    
    }
    
    public String agregar(Empleado p){
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT 1 FROM empleados WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getCodigo());
            ResultSet r = qry.executeQuery();
            if(r.next())
                return "Empleado ya existe";
            String query = "INSERT INTO empleados "
                    + "(codigo, rut, nombre, apellido, celular, email, sueldo_bruto, est_civil, depto)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCodigo());
            ins.setString(2, p.getRut());
            ins.setString(3, p.getNombre());
            ins.setString(4,p.getApellido());
            ins.setString(5,p.getCelular());
            ins.setString(6,p.getCorreo());
            ins.setInt(7, p.getSueldo());
            ins.setString(8, ""+p.getCivil());
            ins.setInt(9, p.getDepto());
            
            ins.executeUpdate();
            return "Empleado Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    
    public String actualizar(Empleado p){
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE empleados "
                    + "SET rut=?, nombre=?, apellido=?, celular=?, email=?, sueldo_bruto=?, est_civil=?, depto=? "
                    + "WHERE codigo=?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setString(1, p.getRut());
            ins.setString(2, p.getNombre());
            ins.setString(3,p.getApellido());
            ins.setString(4,p.getCelular());
            ins.setString(5,p.getCorreo());
            ins.setInt(6, p.getSueldo());
            ins.setString(7, ""+p.getCivil());
            ins.setInt(8, p.getDepto());
            ins.setInt(9, p.getCodigo());
            ins.executeUpdate();
            return "¡Actualizado!";
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }
    
    public Empleado buscar(int codigo){
        Empleado p = null;        
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM empleados WHERE codigo=?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            if(r.next()){
                p = new Empleado();
                p.setApellido(r.getString("apellido"));
                p.setCelular(r.getString("celular"));
                p.setCivil(r.getString("est_civil").charAt(0));
                p.setCodigo(r.getInt("codigo"));
                p.setCorreo(r.getString("email"));
                p.setDepto(r.getInt("depto"));
                p.setNombre(r.getString("nombre"));
                p.setRut(r.getString("rut"));
                p.setSueldo(r.getInt("sueldo_bruto"));
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return p;
    }
    
    public void eliminar(int codigo){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM empleados WHERE codigo=?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();            
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        
    }
   
    public void vaciar(ArrayList<Object> objetos){
        for(Object o:objetos){
            if(o instanceof JTextField==true)
                ((JTextField)o).setText("");
            
            if(o instanceof JComboBox==true)
                ((JComboBox)o).setSelectedIndex(0);
        }
    
    }
    
    public ArrayList<Empleado> listar(){
        ArrayList<Empleado> d = new ArrayList();
        Empleado p =null;
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM empleados";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
                p = new Empleado();
                p.setApellido(r.getString("apellido"));
                p.setCelular(r.getString("celular"));
                p.setCivil(r.getString("est_civil").charAt(0));
                p.setCodigo(r.getInt("codigo"));
                p.setCorreo(r.getString("email"));
                p.setDepto(r.getInt("depto"));
                p.setNombre(r.getString("nombre"));
                p.setRut(r.getString("rut"));
                p.setSueldo(r.getInt("sueldo_bruto"));
                d.add(p);
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return d;
    
    }
    
    
}

