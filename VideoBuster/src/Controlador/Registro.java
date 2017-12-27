/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Pelicula;
import Modelo.Totales;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author daniela
 */
public class Registro {

    public ArrayList<Categoria> getCategoria() {//creo método getCategoria retorna un arreglo 
        ArrayList<Categoria> Categ = new ArrayList();
//creo arreglo llamado Categ que tiene como elementos de clase categoria
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT id, descripcion FROM categoria";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            //mientras voy recibiendo datos
            while (r.next()) {
                Categ.add(new Categoria(r.getInt("id"), r.getString("descripcion")));
            }
            //voy agregando voy agregando al arreglo Categ elementos de la clase categoria, segun constructor 
            //Categoria( int id, String descrpcion)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Categ;
    }

    public String agregar(Pelicula p) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula WHERE codigo =?";
            //"SELECT 1 FROM pelicula WHERE codigo =?"; solicitud para pedir si se retorna un algo
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, p.getCodigo());
            ResultSet r = qry.executeQuery();
            if (r.next()) {//si encuentra el código dentro de la BD retorna el siguiente mensaje
                return "Código ya existe";//return hace que ya no siga la consulta, no se requiere un else
            }
            String query = "INSERT INTO pelicula "
                    + "(codigo, precio, categoria , formato4k, nombre, iva)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, p.getCodigo());
            ins.setInt(2, p.getPrecio());
            ins.setInt(3, p.getCategoria());
            ins.setString(4, p.getFormato4k());
            ins.setString(5, p.getNombre());
            double m = p.getPrecio() * 0.19;
            int n = (int) m;
            ins.setInt(6, n);
            ins.executeUpdate();
            return "Película Ingresado a la Perfección";
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return "Houston, tenemos un problema.";
    }

    public Pelicula buscar(int codigo) {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            ResultSet r = qry.executeQuery();
            //este método no requiere constructor
            if (r.next()) {
                //crea objeto pelota
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                p.setFormato4k(r.getString("formato4k"));
                p.setPrecio(r.getInt("precio"));
                p.setCategoria(r.getInt("categoria"));

                return p;
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
            String consulta = "DELETE FROM pelicula WHERE codigo =?";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.setInt(1, codigo);
            qry.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    //falta arreglar
    public String actualizar(Pelicula p) {
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

    //elimina peliculas cuyo valor es mayo a $2.000
    public void eliminar1() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "DELETE FROM pelicula WHERE precio >2000";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            qry.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public String aumento() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setPrecio(r.getInt("precio"));
                double m = p.getPrecio() * 1.19;
                p.setPrecio((int) m);
                String query = "UPDATE pelicula "
                        + "SET precio=?"
                        + " WHERE codigo=?";
                PreparedStatement ins = conexion.prepareStatement(query);
                ins.setInt(1, p.getPrecio());
                ins.setInt(2, p.getCodigo());
                ins.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return "Realizado Perfectamente";
    }

    public String agregarp() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                String m = "P" + "" + p.getNombre();
                p.setNombre(m);
                String query = "UPDATE pelicula "
                        + "SET nombre=?"
                        + " WHERE codigo=?";
                PreparedStatement ins = conexion.prepareStatement(query);
                ins.setString(1, p.getNombre());
                ins.setInt(2, p.getCodigo());
                ins.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return "Realizado Perfectamente";
    }

    public String mayuscula() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                String m = p.getNombre();
                String mayuscula = m.toUpperCase();
                p.setNombre(mayuscula);
                String query = "UPDATE pelicula "
                        + "SET nombre=?"
                        + " WHERE codigo=?";
                PreparedStatement ins = conexion.prepareStatement(query);
                ins.setString(1, p.getNombre());
                ins.setInt(2, p.getCodigo());
                ins.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return "Realizado Perfectamente";
    }

    public String minuscula() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                String m = p.getNombre();
                String minuscula = m.toLowerCase();
                p.setNombre(minuscula);
                String query = "UPDATE pelicula "
                        + "SET nombre=?"
                        + " WHERE codigo=?";
                PreparedStatement ins = conexion.prepareStatement(query);
                ins.setString(1, p.getNombre());
                ins.setInt(2, p.getCodigo());
                ins.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return "Realizado Perfectamente";
    }

    public String letramayus() {
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT * FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(r.getInt("codigo"));
                p.setNombre(r.getString("nombre"));
                String m = p.getNombre();//string que debo recorrer
                char c = ' ';
                int aux = 0;
                for (int i = 0; i < m.length(); i++) {
                    c = m.charAt(i);
                    if (i == 0) {
                        c = Character.toUpperCase(c);
                    }
                    if (i >= 1) {
                        c = Character.toLowerCase(c);
                    }
                    if (c == ' ') {
                        aux = (i + 1);//variable aux guarda la posicion siguiente
                    }
                    if (aux == i) {
                        c = Character.toUpperCase(c);
                    }
                }
                p.setNombre(m);
                String query = "UPDATE pelicula "
                        + "SET nombre=?"
                        + " WHERE codigo=?";
                PreparedStatement ins = conexion.prepareStatement(query);
                ins.setString(1, p.getNombre());
                ins.setInt(2, p.getCodigo());
                ins.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return "Realizado Perfectamente";
    }

    public Totales totales() {
        Totales t = new Totales();
        int total = 0;
        
        try {
            Connection conexion = Conexion.getConexion();
            String consulta = "SELECT precio, iva  FROM pelicula";
            PreparedStatement qry = conexion.prepareStatement(consulta);
            ResultSet r = qry.executeQuery();
            while (r.next()) {
                total = (total + (r.getInt("precio")+r.getInt("iva")));   
            }
            t.setTotales(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

}
