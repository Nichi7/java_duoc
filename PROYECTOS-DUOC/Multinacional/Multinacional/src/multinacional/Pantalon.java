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
public class Pantalon extends Producto{
    private String tipo;
    private char sexo;

    public Pantalon(String tipo, char sexo, int codigo, int preciobase, int stock) {
        super(codigo, preciobase, stock);
        this.tipo = tipo;
        this.sexo = sexo;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString(){
        String cadena="";
        cadena+="Tipo: "+this.tipo+"\t";
        cadena+="Sexo: "+this.sexo+"\t";
        
        return "Pantalón: "+super.toString()+cadena;
    }
}
