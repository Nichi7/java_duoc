package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar{

    static String bd = "producto";
    static String login = "root";
    static String password = "Daniela30/";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexion a base de datos "+bd+" OK");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        connection = null;
    }


}
