/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author daniela
 */
public class Usuario {
    private String mail;
    private String pass;
    private String name;
    private List<Error> errores;
    //Crea constructor para inicializar las variables
    //constructor para validar ingreso
    public Usuario(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;    
        errores = new ArrayList<Error>(); 
        //cree lista vacia, en java 7 no va
    }
    //constructor que entregue los 3 parametros

    public Usuario(String mail, String pass, String name) {
        this.mail = mail;
        this.pass = pass;
        this.name = name;
         errores = new ArrayList<Error>(); 
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //crear metodo que agregue un error
    public void addError(Error error){
        //agrega error a la lista
        errores.add(error);
    }
    //crea metodo que verifica si existe error
    public boolean errorExiste() {
        return !errores.isEmpty();
    }

    public List<Error> getErrores() {
        return errores;
    }
    
}
