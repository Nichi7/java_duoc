/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;
import sql.Conexion;
import vista.Insertar;
/**
 *
 * @author Concepción
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Insertar t = new Insertar();
       t.setVisible(true);
       Conexion.getConexion();
    }
    
}
