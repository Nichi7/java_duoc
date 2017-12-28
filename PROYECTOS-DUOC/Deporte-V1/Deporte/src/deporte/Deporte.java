/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deporte;

import java.sql.Connection;
import sql.Conexion;
import vista.Mantenedor;

/**
 *
 * @author Xberto
 */
public class Deporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection t = Conexion.getConexion();
        Mantenedor m = new Mantenedor();
        m.setVisible(true);
    }
    
}
