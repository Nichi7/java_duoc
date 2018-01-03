/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import SERVICIOS.DB.Conexion;

/**
 *
 * @author Leo
 */
public class Servicios {
    private static Servicios instancia;
    private boolean DEBUG = true;
    private Conexion cdb;
    
    public Servicios() {
    }
    
        
    public static synchronized Servicios getInstancia(){
        if (instancia == null){
            instancia = new Servicios();
        }
        return instancia;
    }
    
    
    
    public boolean DEBUG()
    {
        return this.DEBUG;
    }
    
        
    public Conexion DB() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException{
        if (cdb == null){
            String nombreClase = "SERVICIOS.DB.ConexionMySql";

            cdb = (Conexion) Class.forName(nombreClase).newInstance();
        }
        return cdb;
    }
    
}
