/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodatos.ProductoDAO;
import java.sql.SQLException;

/**
 *
 * @author Jazna
 */
public class Producto {

    private int id;
    private String nombre, moneda;
    private float valorMoneda;

    public Producto() {
    }

    public Producto(int id) {
        this.id = id;
    }
//constructor con argumentos
    public Producto(int id, String nombre, String moneda, float valorMoneda) {
        this.id = id;
        this.nombre = nombre;
        this.moneda = moneda;
        this.valorMoneda = valorMoneda;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getValorMoneda() {
        return valorMoneda;
    }

    public void setValorMoneda(float valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

   /*public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        ProductoDAO bdb = new ProductoDAO();
        bdb.grabar();
    }*/
}
