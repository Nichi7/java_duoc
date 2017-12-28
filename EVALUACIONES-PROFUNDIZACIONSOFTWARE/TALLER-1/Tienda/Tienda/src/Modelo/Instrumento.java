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
public abstract class Instrumento {
    private int codigo;
    private String nombre;
    private int stock;

    public Instrumento(int codigo, String nombre, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
@Override
    public String toString(){
        String palabra="";
        palabra+="Código: "+this.codigo+"\t";
        palabra+="Nombre: "+this.nombre+"\t";
        palabra+="Stock: "+this.stock+"\t";
        return palabra;
        
    }
    //me permite comprobar que un objeto (instrumento) ya existe según repetición del código ingresado
    @Override
    public boolean equals(Object t){
        if(t==this)
            return true;
        Instrumento in = (Instrumento)t;
        return this.codigo==in.getCodigo();
    }
    
}
