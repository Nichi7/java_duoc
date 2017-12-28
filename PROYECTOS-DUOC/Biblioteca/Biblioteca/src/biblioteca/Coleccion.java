/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Concepción
 */
public class Coleccion {
    private static ArrayList<Documento> lista =null;
    private static Coleccion coleccion = null;
    private Coleccion(){
        lista = new ArrayList();
    }
    
    public static Coleccion getInstancia(){
        if(coleccion==null)
            coleccion = new Coleccion();
        return coleccion;
    }
    public void agregar(Documento d){
        lista.add(d);
    }
    public void eliminar(int codigo){
        int largo = lista.size();
        for(int i = 0;i<largo;i++){
            if(lista.get(i).getCodigo()==codigo){
                lista.remove(i);
                break;
            }
        }
    }
    public String listar(){
        String cadena="";
        for(Documento d: lista){
            cadena+=d.getTitulo()+"\n";
        }
        return cadena;
    }
    
    public boolean existe(int codigo){
        for(Documento d: lista){
            if(d.getCodigo()==codigo)
                    return true;
        }
        return false;
    }
    
}
