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
public class Arbol extends Semilla {

    private int alturaMax;

    public Arbol(int alturaMax, int codigo, String nombre, int precio) {
        super(codigo, nombre, precio);
        this.alturaMax = alturaMax;
    }

    public int getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(int alturaMax) {
        if (alturaMax > 0) {
            this.alturaMax = alturaMax;
        }
    }

    @Override
    public void CalcularPrecioOferta() {
        if (this.alturaMax > 180) {
            this.precioOferta = this.precio - (this.precio * desc_arbol);
        } else {
            this.precioOferta = this.precio;
        }

    }
    /*@Override
public String toString(){
        String cadena="Precio Oferta: "+this.precioOferta+"\t";
        return super.toString()+cadena;
    }*/
}
