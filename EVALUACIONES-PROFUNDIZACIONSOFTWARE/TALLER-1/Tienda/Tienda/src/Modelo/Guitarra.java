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
public class Guitarra extends Instrumento {
    private String tipo;

    public Guitarra(String tipo, int codigo, String nombre, int stock) {
        super(codigo, nombre, stock);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }   
    @Override
    public String toString(){
        String cadena="Tipo: "+this.tipo+"\t";
        return super.toString()+cadena;    
    }
}

