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
public abstract class Producto {
    private int codigo;
    private int preciobase;
    private int stock;

    public Producto(int codigo, int preciobase, int stock) {
        this.codigo = codigo;
        this.preciobase = preciobase;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPreciobase() {
        return preciobase;
    }

    public void setPreciobase(int preciobase) {
        this.preciobase = preciobase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString(){
        String palabra="";
        palabra+="Código: "+this.codigo+"\t";
        palabra+="Stock: "+this.stock+"\t";
        palabra+="Precio: "+this.preciobase+"\t";
        return palabra;
        
    }
    
    
    
    @Override
    public boolean equals(Object t){
        if(t==this)
            return true;
        Producto p = (Producto)t;
        return this.codigo==p.getCodigo();
    }
    
}
