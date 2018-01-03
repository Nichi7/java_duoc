/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS.DB;

import SERVICIOS.DB.Conexion;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jazna
 */
public final class ConexionMySql extends Conexion{
    private final String opciones;
    private static final String JDBC = "jdbc:mysql://";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost:3306";

    /** Creates a new instance of Conexion_MySQL usando un username y password
     * @param database Nombre de la base de datos
     * @param username Nombre del usuario de conexión
     * @param password Password de conexión
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public ConexionMySql(String database, String username,
                          String password) throws java.lang.ClassNotFoundException,
                                           java.lang.InstantiationException,
                                           java.lang.IllegalAccessException,
                                           java.sql.SQLException{
        super(JDBC, DRIVER, HOST, database, username, password);
        this.opciones = "charSet=LATIN1";
        //initdb();
    }
    
    public ConexionMySql() throws java.lang.ClassNotFoundException,
                                           java.lang.InstantiationException,
                                           java.lang.IllegalAccessException,
                                           java.sql.SQLException{
        this("chocolates", "root", "qwertyuiop");
/*
    }
    
    public void initdb() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException{
  */      
        s_conexion = jdbc + host + "/" + database; 
        Class.forName(driver).newInstance();

        // Aqui se usan las opciones
        conexion = DriverManager.getConnection(jdbc + host + "/" + database + "?" + opciones, username, password);
        dbmd = conexion.getMetaData();
        un_st = conexion.createStatement();
    }    

    @Override
    public void testSqlSelect() {
        PreparedStatement ps = null;
        try {
            String query = "select codigo, nombre, descripcion, precioventa, cantidad, tipocolor, tiposabor, marca, azucar from chocolate";
            ps = this.conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            System.out.println("void ConexionMysql.testSqlSelect()");
            System.out.println("-----------------------------------");
            
            while (rs.next())
            {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getNString("nombre");
                String descripcion = rs.getString("descripcion");
                int precioventa = rs.getInt("precioventa");
                int cantidad = rs.getInt("cantidad");
                String tipocolor = rs.getString("tipocolor");
                String tiposabor = rs.getString("tiposabor");
                String marca = rs.getString("marca");
                Boolean azucar = rs.getBoolean("azucar");
                
                System.out.println("'"+codigo + "' , '" + nombre + "' , '" + descripcion + "' , " + precioventa + ", " + cantidad + ", '" + tipocolor + "', '" + tiposabor + "', '" + marca + "', " + azucar);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
           if (ps != null)
           {
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    }
}
