/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author daniela
 */
public class Database {
    //los atributos, central las credencialaes de conexion db
    private String url;
    private String user;
    private String contra;
    private String driver;

    public Database() {
        this.url = "jdbc:mysql://localhost:3306/sisv11";
        this.user = "root";
        this.contra = "Daniela30/";
        this.driver ="com.mysql.jdbc.Driver" ;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }

    public String getDriver() {
        return driver;
    }
    
    
    
    
    
    
}
