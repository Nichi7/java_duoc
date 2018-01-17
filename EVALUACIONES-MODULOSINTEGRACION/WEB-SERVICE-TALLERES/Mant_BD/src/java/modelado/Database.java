/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

/**
 *
 * @author daniela
 */

//clase para centralizar las credenciales de conexion a mysql
public class Database {
    //atributos o campos
    private String driver;
    private String url;
    private String usuario;
    private String contraseña;

    public Database() {
        //el constructor inicializa las credenciales para conectarme a mysql
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/tutorial";
        this.usuario = "root";
        this.contraseña = "Daniela30/";
    }
    //getter para obtener desde afuera las credenciales
    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
    
    
}
