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
import Taller2.Semilla;

public class Botanico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //se crea objeto e ingresan argumentos
        Flor rosa = new Flor("NARANJA", 100, "ROSAS", 1000);
        rosa.CalcularPrecioOferta(); //se llama al método 
        Flor violetas = new Flor("AZUL", 101, "VIOLETA", 800);
        violetas.CalcularPrecioOferta();
        Flor petunias = new Flor("BLANCAS", 102, "PETUNIAS", 1200);
        petunias.CalcularPrecioOferta();
        //crear semillar de arbol + Calcular precio oferta 
        Arbol pino = new Arbol(200, 200, "PINOS", 2500);
        pino.CalcularPrecioOferta(); //unico con descuento
        Arbol cerezo = new Arbol(250, 201, "CEREZO", 2000);
        cerezo.CalcularPrecioOferta();
        Arbol castanio = new Arbol(150, 202, "CASTAÑO", 2500);
        castanio.CalcularPrecioOferta();
        //agregarlas al arraylist
        Inventario inventario = new Inventario();
        inventario.agregar(rosa);
        inventario.agregar(violetas);
        inventario.agregar(petunias);
        inventario.agregar(pino);
        inventario.agregar(cerezo);
        inventario.agregar(castanio);
        //mostrar arraylist completo
        System.out.println(inventario.Buscar(201)); //esta
        System.out.println(inventario.Buscar(200)); //no deberia estar
        //imprimir el inventario
        inventario.Imprimir();
        //eliminar rosas y uno que no esta (demostrar que no se cae)
        inventario.eliminar(100);
        inventario.eliminar(205);
        //imprimir nuevamente el inventario
        inventario.Imprimir();

    }
    //se implementan los mètodos del programa inventario
}
