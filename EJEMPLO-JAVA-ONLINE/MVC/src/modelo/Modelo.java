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
public class Modelo {
    private int numerouno;
    private int numerodos;
    private int resultado;

    public int getNumerouno() {
        return numerouno;
    }

    public void setNumerouno(int numerouno) {
        this.numerouno = numerouno;
    }

    public int getNumerodos() {
        return numerodos;
    }

    public void setNumerodos(int numerodos) {
        this.numerodos = numerodos;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    //crea metodo multiplicar
    public int multiplicar()
    {
        this.resultado = this.numerouno * this.numerodos;
        return this.resultado;
    }
    
    
}
