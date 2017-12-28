/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Vista.Inicio;
import sql.Conexion;

/**
 *
 * @author daniela
 */
public class VideoBuster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.getConexion();
        Inicio in = new Inicio();
        in.setVisible(true);
        // TODO code application logic here
    }
    
}
