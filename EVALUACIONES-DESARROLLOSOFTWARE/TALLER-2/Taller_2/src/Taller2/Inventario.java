/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller2;

import java.util.ArrayList;

/**
 *
 * @author daniela
 */
public class Inventario {

    //se crea arraylist donde se guardan semillas
    public ArrayList<Semilla> inventario = new ArrayList<>();

    //se crea constructor sin argumentos
    public Inventario() {
    }
    //se crea método agregar semilla a la colección

    public boolean agregar(Semilla s) {
        //recorre arreglo
        for (Semilla t : inventario) {
            if (s.equals(t)) {
                return false;
            }
        }
        return this.inventario.add(s);
    }

    public boolean eliminar(int codigo) {
        for (Semilla t : inventario) {
            if (t.getCodigo() == codigo) {
                inventario.remove(t);
                System.out.println("Semilla eliminada Correctamente");
                return true;
            }
        }
        System.out.println("No existe Semilla");
        return false;
    }

    /*public String buscar(){
        String r = "";
        for(Semilla t: inventario)
            r+=t.toString()+"\n";
        return r;
    }*/

 /*Método 1 oara buscar producto por código 
    public boolean Buscar (int codigo){
        for (int i = 0; i < inventario.size(); i ++)
        {
            if(inventario.get(i).getCodigo() == codigo) 
            {
            return true;
            }
        }
        return false;
    }*/
    public String Buscar(int codigo) {
        for (Semilla t : inventario) {
            String r = "";
            
            if (t.getCodigo() == codigo) {
                r = "Semilla existe";
                return r;
            }
        }
        return "Semilla no existe";
    }
        

public void Imprimir() {
        System.out.println("----------------");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("Codigo: " + inventario.get(i).getCodigo() + " Nombre: " + inventario.get(i).getNombre() + " Precio: $" + inventario.get(i).getPrecio() + " Precio Oferta: $" + inventario.get(i).getPrecioOferta());
        }
        System.out.println("----------------");
    }
    /*public String Buscar(){
        String r = "";
        for(Semilla t: inventario)
            r+=t.toString()+"\n";
        return r;
    }*/
}
