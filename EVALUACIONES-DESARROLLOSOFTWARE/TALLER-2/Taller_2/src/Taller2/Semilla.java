/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller2;

/**
 *
 * @author daniela
 */
//se defina la clase semilla como abstracta, puede o no implementar métodos, hereda de una clase interface Vendible
public abstract class Semilla implements Vendible {
    //declaran los atributos
    protected int codigo;
    protected String nombre;
    protected int precio;
    protected double precioOferta;
   //crea constructor con argumentos

    public Semilla(int codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
//crea los accesadores
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }
    
//se crean los mutadores y definen reglas de negocio
    public void setCodigo(int codigo) {
        if(codigo>99 && codigo<1000)
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if(nombre.length()>=5)
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if(precio>0)
        this.precio = precio;
    }
    /*@Override
    public String toString(){
        String palabra="";
        palabra+="Código: "+this.codigo+"\t";
        palabra+="Stock: "+this.nombre+"\t";
        palabra+="Precio: "+this.precio+"\t";
        return palabra;
        
    }*/
}
