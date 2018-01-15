/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

    public Pelicula() {
    }

    public Pelicula(int codigo, int precio, int categoria, String formato4k, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.formato4k = formato4k;
        this.nombre = nombre;
    }
    

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
    
}
