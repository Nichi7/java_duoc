/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Xberto
 */
public class Zapato {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;
    private boolean stock;
    private int cantidad;
    private String color;
    private String tipo;
    private boolean sexo;
    private int numero;

    public Zapato(int codigo, String nombre, String descripcion, int precio, boolean stock, int cantidad, String color, String tipo, boolean sexo, int numero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.cantidad = cantidad;
        this.color = color;
        this.tipo = tipo;
        this.sexo = sexo;
        this.numero = numero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean isStock() {
        return stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isSexo() {
        return sexo;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
}
