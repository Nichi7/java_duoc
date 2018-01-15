/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daniela
 */
public class Categoria {
   
    private int codigo;
    private String descrip;

    public Categoria() {
    }

    public Categoria(int codigo, String descrip) {
        this.codigo = codigo;
        this.descrip = descrip;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescrip() {
        return descrip;
    }
      
}
