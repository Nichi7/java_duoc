/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import sql.Conexion;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author daniela
 */
public class Registro {

    public String agregar(Empleados em) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM empleados WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, em.getCodigo());
            ResultSet r = qry.executeQuery();
            if (r.next()) {
                return "Código ya existe";
            }
            String query = "INSERT INTO empleados "
                    + "(codigo, rut, nombre , apellido, celular, email, sueldo_bruto, est_civil, nom_dept)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, em.getCodigo());
            ins.setString(2, em.getRut());
            ins.setString(3, em.getNombre());
            ins.setString(4, em.getApellido());
            ins.setInt(5, em.getCelular());
            ins.setString(6, em.getEmail());
            ins.setInt(7, em.getSueldo());
            // si estado fuera un char transformacion a String seria ins.setString(8,""+em.getEstado());
            ins.setString(8, em.getEstado());
            ins.setString(9, em.getDepto());
            ins.executeUpdate();
            return "Empleado Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }

    public Empleados buscar(int codigo) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM empleados WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if (r.next()) {//se que me retorna algo la consulta
                //crea objeto pelota
                Empleados em = new Empleados();
                em.setCodigo(r.getInt("codigo"));
                em.setRut(r.getString("rut"));
                em.setNombre(r.getString("nombre"));
                em.setApellido(r.getString("apellido"));
                em.setCelular(r.getInt("celular"));
                em.setEmail(r.getString("email"));
                em.setSueldo(r.getInt("sueldo_bruto"));
                em.setEstado(r.getString("est_civil"));
                em.setDepto(r.getString("nom_dept"));

                return em;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void eliminar(int codigo) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM empleados WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    //falta arreglar
    public String actualizar(Empleados em) {
        try {
            Connection conexion = Conexion.getConexion();

            String query = "UPDATE empleados "
                    + "set rut=?, nombre=?, apellido=?, celular=?, email=?, sueldo_bruto=?, est_civil=?, nom_dept=?"
                    + " WHERE codigo = ?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setString(1, em.getRut());
            ins.setString(2, em.getNombre());
            ins.setString(3, em.getApellido());
            ins.setInt(4, em.getCelular());
            ins.setString(5, em.getEmail());
            ins.setInt(6, em.getSueldo());
            ins.setString(7, em.getEstado());
            ins.setString(8, em.getDepto());
            ins.setInt(9, em.getCodigo());
            ins.executeUpdate();
            return "Actualización a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }

    
    public String aumento(){
        try{
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM empleados";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
               Empleados p = new Empleados();
               p.setCodigo(r.getInt("codigo"));
               p.setSueldo(r.getInt("sueldo_bruto"));
               double m = p.getSueldo() * 1.10;
               p.setSueldo((int)m);
               String query = "UPDATE empleados "
                    + "SET sueldo_bruto=?"
                    + " WHERE codigo=?";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getSueldo());
            ins.setInt(2, p.getCodigo());
            ins.executeUpdate();
               }
                }catch(Exception e){
             System.out.println("Error al modificar "+e.getMessage());
        }
        return "Realizado Perfectamente";    
    
    }
    /*public void vaciar(ArrayList<Object> objetos){
        for (Object o : objetos){//recorre arreglo objetos con elementos object
            if(instanceof JTextField==true)
                
            
        }*/
    //elimina peliculas cuyo valor es mayo a $2.000
    public boolean eliminar1() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM empleados WHERE sueldo_bruto=120000";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return false;
    }
    //se crea un metodo llamado listar que devuelve como dato un arraylist
    public ArrayList<Empleados> listar(){
        //se crea un arraylist llamado dconformado por elementos de clase Empleados
        ArrayList<Empleados> d = new ArrayList();
        //se crea una variable de tipo Empleados que se inializa vacia
        Empleados p =null;
        try{
            Connection conexion = Conexion.getConexion();
            //se pueden hacer diferentes tipos de consulta a la base de datos para mostrar en jtable
            String consulta = "SELECT *FROM empleados WHERE nom_dept ='Finanzas'";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while(r.next()){
                //se crea un objeto p de elemento empleados
                p = new Empleados();
                p.setCodigo(r.getInt("codigo"));
                p.setRut(r.getString("rut"));
                p.setNombre(r.getString("nombre"));
                p.setApellido(r.getString("apellido"));
                p.setCelular(r.getInt("celular"));
                p.setEmail(r.getString("email"));
                p.setEstado(r.getString("est_civil"));
                p.setSueldo(r.getInt("sueldo_bruto"));
                p.setDepto(r.getString("nom_dept"));
                d.add(p); //se implementa metodo add, para agregar el objeto empleados a arraylits d
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        return d;
    
    }
    //se crea un método publico que no retorna algo,que tiene como argumentos que se le debe ingresar un arraylist de nombre objetos
    public void vaciar(ArrayList<Object> objetos){
        //se recorre el arraylist conformado por elementos tipo object
        for(Object o:objetos){
            if(o instanceof JTextField==true)
                ((JTextField)o).setText("");
            
            if(o instanceof JComboBox==true)
                ((JComboBox)o).setSelectedIndex(0);
            
            /*if(o instanceof JRadioButton==true)
            ((JRadioButton)o).setSelected(false);*/
            if(o instanceof ButtonGroup==true)
                ((ButtonGroup)o).clearSelection();
        }
    
    }
    }

