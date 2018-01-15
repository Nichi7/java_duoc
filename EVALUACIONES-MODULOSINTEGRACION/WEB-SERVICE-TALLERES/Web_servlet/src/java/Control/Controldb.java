/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.*;
import Entities.Usuario;

/**
 * se importa libreria para manejo de operaciones con la base de datos
 * relacional
 *
 * @author daniela
 */
public class Controldb {

    //crea atributo de la clases connection
    private Connection con = null;
    private String lastError = null;

    public String getLastError() {
        return lastError;
    }

    //crea metodo conectar, no retorna un valor al ser void
    public boolean conectar(String bd, String usuario, String clave) {
        //es obligario el uso del try -catch o throws para confirmacion de bd
        try {
            //se crea un ejemplar del driver JDBC para mysql, método para invocar al driver
            Class.forName("com.mysql.jdbc.Driver");
            /* el formato del URL del driver es el siguiente : jdbc:mysql://
           [host:port]/[database][?propertyName1][=propertyValue1]&[?propertyName2][=propertyValue2]
           si el puerto no es especificado, por omision se considera el puerto 3306
             */
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + bd + "?user=" + usuario + "&password=" + clave);
            return true;
            ////System.out.println(""conectado");

        } catch (ClassNotFoundException cnfe) {
            lastError = cnfe.getMessage();
            return false;
            //System.out.println(cnfe.getMessage());

        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
            return false;
            //System.out.println(sqle.getMessage());
        }
    }

    //metodo desconectar
    public boolean desconectar() {
        try { //si no esta conectado
            if (con != null) {
                con.close();
            }
            con = null;
            return true;
            //System.out.println("desconectado");

        } catch (Exception e) {
            lastError = e.getMessage();
            return false;
            //System.out.println(e.getMessage());
        }
    }

    public boolean registroUsuarios (Usuario oUsuario)
    {
        String sentenciaSQL = "INSERT INTO tusuarios VALUES ('"+ 
                oUsuario.getUsuario() + "','"+ 
                oUsuario.getClave() + "','" + 
                oUsuario.getNombre() + "','"+ 
                oUsuario.getTipo() +"');";
        try 
            {
                /*se crea el objeto statement , statement es una clase que invoca o genera un COMANDO SQL para 
                ser enviado por una conexion a una base de datos*/
                Statement stm = con.createStatement();
                //se invoca al metodo executeUpdate , solo UPDATE, DELETE, INSERT y se coloca como parametro la sentenciasql a ejecutar
                int filasAfectadas = stm.executeUpdate(sentenciaSQL);
                //las filas afectadas son devueltas y caen en la variable filasafectadas
                if ( filasAfectadas > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                    
                }
            }catch (SQLException sqle)
                        {
                        lastError = sqle.getMessage();
                        return false;
                        }
                
            }
}


