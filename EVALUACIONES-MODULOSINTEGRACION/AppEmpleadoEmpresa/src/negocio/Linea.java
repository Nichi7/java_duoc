/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodatos.LineaDAO;
import java.sql.SQLException;

/**
 *
 * @author Jazna
 */
public class Linea {
    private int id;
    private String nombre;

    public Linea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Linea() {
    }

    public Linea(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        LineaDAO ldb = new LineaDAO(this);
        ldb.grabar();
    }
}
