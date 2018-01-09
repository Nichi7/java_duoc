/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniela
 */
public class Pelicula {
    private int codigo;
    private int precio;
    private int categoria;
    private String formato4k;
    private String nombre;
    //accesadores

    public int getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getFormato4k() {
        return formato4k;
    }

    public String getNombre() {
        return nombre;
    }
    //modificadores

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setFormato4k(String formato4k) {
        this.formato4k = formato4k;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
