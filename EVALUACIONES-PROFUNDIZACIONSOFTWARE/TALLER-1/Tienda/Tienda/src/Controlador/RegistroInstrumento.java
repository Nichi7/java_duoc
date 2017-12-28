/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Instrumento;
import java.util.ArrayList;

/**
 *
 * @author Concepción
 */
public class RegistroInstrumento {
    private ArrayList<Instrumento> instrumentos = null;
    private static RegistroInstrumento instancia = null;
    
    private RegistroInstrumento(){
        this.instrumentos = new ArrayList();
    }
    public static RegistroInstrumento getInstancia(){
        if(instancia==null)
            instancia = new RegistroInstrumento();
        return instancia;
    }
    
    public boolean ingresar(Instrumento i){
        for(Instrumento t: instrumentos){
            if(i.equals(t))
                return false;
        }
        return this.instrumentos.add(i);
    }
    public String showAll(){
        String r = "";
        for(Instrumento t: instrumentos)
            r+=t.toString()+"\n";
        return r;
    }
    
    public boolean eliminar(int codigo){
        for(Instrumento t: instrumentos){
            if(t.getCodigo()==codigo){
                instrumentos.remove(t);
                return true;
            }           
        }
        return false;
    }
}

    

