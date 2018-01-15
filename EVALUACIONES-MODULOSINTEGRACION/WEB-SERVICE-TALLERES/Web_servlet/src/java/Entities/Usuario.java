/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Concepción
 */
public class Usuario {

    private String usuario;
    private String clave;
    private String nombre;
    private char tipo;

    public Usuario(String usuario, String clave, String nombre, char tipo) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

}
