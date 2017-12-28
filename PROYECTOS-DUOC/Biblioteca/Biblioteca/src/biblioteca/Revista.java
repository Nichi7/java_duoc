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
public class Revista extends Documento{
    private int volumen;
    private int numero;
    private String mes;

    public Revista(int volumen, int numero, String mes, int codigo, String titulo, String autor, String editorial, int publicacion) {
        super(codigo, titulo, autor, editorial, publicacion);
        this.volumen = volumen;
        this.numero = numero;
        this.mes = mes;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
