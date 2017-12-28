/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Vista.Buscar;
import Vista.Ingresar;
import java.sql.Connection;
import sql.Conexion;

/**
 *
 * @author Xberto
 */
public class Zapateria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buscar i = new Buscar();
        i.setVisible(true);
        Connection t = Conexion.getConexion();
    }
    
}
