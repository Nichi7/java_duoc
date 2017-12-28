/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinacional;

import java.util.ArrayList;
import java.sql.Array;
//se modifica algo
/**
 *
 * @author Xberto
 */
public class RegistroProducto {
    
    private ArrayList<Producto> productos = null;
    private static RegistroProducto instancia = null;
    
    private RegistroProducto(){
        this.productos = new ArrayList();
    }
    public static RegistroProducto getInstancia(){
        if(instancia==null)
            instancia = new RegistroProducto();
        return instancia;
    }
    
    public boolean agregar(Producto p){
        for(Producto t: productos){
            if(p.equals(t))
                return false;
        }
        return this.productos.add(p);
    }
    public String showAll(){
        String r = "";
        for(Producto t: productos)
            r+=t.toString()+"\n";
        return r;
    }
    
    public boolean eliminar(int codigo){
        for(Producto t: productos){
            if(t.getCodigo()==codigo){
                productos.remove(t);
                return true;
            }           
        }
        return false;
    }
}
