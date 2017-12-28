/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Concepción
 */
public class Libro extends Documento{
    
    boolean prestado;

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Libro(boolean prestado, int codigo, String titulo, String autor, String editorial, int publicacion) {
        super(codigo, titulo, autor, editorial, publicacion);
        this.prestado = prestado;
    }
    
    
}
