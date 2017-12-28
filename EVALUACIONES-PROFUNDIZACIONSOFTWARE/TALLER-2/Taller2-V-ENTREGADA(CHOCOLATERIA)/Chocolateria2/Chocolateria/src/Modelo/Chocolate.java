/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Concepción
 */
public class Chocolate {
    //declarar atributos
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    private String tipo;
    private String tipo_choc;
    private String marca;
    private boolean azucar;

    /*public Chocolate(int codigo, String nombre, String descripcion, int precio, int cantidad, char tipo, String tipo_choc, String marca, boolean azucar) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.tipo_choc = tipo_choc;
        this.marca = marca;
        this.azucar = azucar;*/
    //accesadores

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

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipo_choc() {
        return tipo_choc;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isAzucar() {
        return azucar;
    }
    //modificadores

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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipo_choc(String tipo_choc) {
        this.tipo_choc = tipo_choc;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAzucar(boolean azucar) {
        this.azucar = azucar;
    }
    
    }
    
    
    

