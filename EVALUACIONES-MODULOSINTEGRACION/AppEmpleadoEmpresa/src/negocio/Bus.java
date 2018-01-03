/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodatos.BusDAO;
import java.sql.SQLException;

/**
 *
 * @author Jazna
 */
public class Bus {
    private String patente;
    private Linea linea;

    public Bus() {
    }

    public Bus(String patente) {
        this.patente = patente;
    }

    public Bus(String patente, Linea linea) {
        this.patente = patente;
        this.linea = linea;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }
    
    public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        BusDAO bdb = new BusDAO(this);
        bdb.grabar();
    }
}
