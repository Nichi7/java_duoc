/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;

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

    public boolean registroUsuarios(Usuario oUsuario) {
        String sentenciaSQL = "INSERT INTO tusuarios VALUES ('"
                + oUsuario.getUsuario() + "','"
                + oUsuario.getClave() + "','"
                + oUsuario.getNombre() + "','"
                + oUsuario.getTipoUsuario() + "');";
        try {
            /*se crea el objeto statement , statement es una clase que invoca o genera un COMANDO SQL para 
                ser enviado por una conexion a una base de datos*/
            Statement stm = con.createStatement();
            //se invoca al metodo executeUpdate , solo UPDATE, DELETE, INSERT y se coloca como parametro la sentenciasql a ejecutar
            int filasAfectadas = stm.executeUpdate(sentenciaSQL);
            //las filas afectadas son devueltas y caen en la variable filasafectadas
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;

            }
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
            return false;
        }

    }

    public boolean consultaUsuarios() {
        //declaran atributos
        ResultSet rs;
        Statement stm;
        String sentenciaSQL = "SELECT * FROM tusuarios;";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sentenciaSQL);
            /* del resulset se llama al metodo metadata(), devuelve la informacion que describre lo que hay en esa consulta,     columncount devuelve 
        la cantidad de columnas hay*/
            int cantidad_campos = rs.getMetaData().getColumnCount();
            int i;
            //si hay un primer registro que hace?
            if (rs.next()) {
                i = 1;
                while (i <= cantidad_campos) {
                    //imprime el nombre de los campos o columnas una sola ves al realizarse un if
                    System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
                    i++;
                }
            }
            while (rs.next()) {
                System.out.println("");
                System.out.print(rs.getString("usuario") + "\t\t");
                System.out.print("oculto" + "\t\t");
                System.out.print(rs.getString("nombre") + "\t\t");
                System.out.print(rs.getString("tipo"));
                System.out.println("");

            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
