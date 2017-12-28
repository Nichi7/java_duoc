/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Concepción
 */
public class Ventas {
    private int ventas;
    private int cantidad;

    public Ventas(int ventas, int cantidad) {
        this.ventas = ventas;
        this.cantidad = cantidad;
    }

    public Ventas() {
    }
    

    public int getVentas() {
        return ventas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
