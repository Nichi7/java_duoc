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
//como es un clase normal debe si o si implementar los mètodos de la interface
public class Flor extends Semilla {

    private String color;
    //crea constructor con argumentos,hereda del padre semilla

    public Flor(String color, int codigo, String nombre, int precio) {
        super(codigo, nombre, precio);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    //implementa método interface vendible
    public void CalcularPrecioOferta() {
        if (!"ROJO".equals(this.color)) {
            this.precioOferta = this.precio - (this.precio * desc_flor);
        } else {
            this.precioOferta = this.precio;
        }

    }
/* @Override
public String toString(){
        String cadena="Precio Oferta: "+this.precioOferta+"\t";
        return super.toString()+cadena;
    }*/
}
