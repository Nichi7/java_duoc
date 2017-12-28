/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinacional;

/**
 *
 * @author Xberto
 */
public abstract class Electrodomestico extends Producto implements ProductoDescontable{
    private String marca;

    public Electrodomestico(String marca, int codigo, int preciobase, int stock) {
        super(codigo, preciobase, stock);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString(){
        String cadena="Marca: "+this.marca+"\t";
        return super.toString()+cadena;    
    }
}
