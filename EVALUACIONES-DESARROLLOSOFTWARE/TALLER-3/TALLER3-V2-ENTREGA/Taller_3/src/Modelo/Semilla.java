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
public  class Semilla {
    //declaran los atributos
    private int codigo;
    private String nombre;
    private int precio;
    private String tipo;
    
   //crea constructor con argumentos

    /*public Semilla(int codigo, String nombre, int precio, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }*/
   
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

    public String getTipo() {
        return tipo;
    }   
//se crean los mutadores y definen reglas de negocio

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

