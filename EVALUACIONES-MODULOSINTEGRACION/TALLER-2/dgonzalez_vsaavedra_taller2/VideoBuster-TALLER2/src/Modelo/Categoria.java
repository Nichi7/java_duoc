/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniela
 */
public class Categoria {
    private int codigo;
    private String descrip;
    //crear constructor con argumentos

    public Categoria(int codigo, String descrip) {
        this.codigo = codigo;
        this.descrip = descrip;
    }

    public Categoria() {
    }
    
    //accesadores

    public int getCodigo() {
        return codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    @Override
    public String toString(){
        return descrip;
    }
    
    
}
