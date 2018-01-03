/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import CONTROLADOR.NEGOCIO.ControladorNegocio;
import SERVICIOS.DB.Conexion;
import SERVICIOS.Servicios;
import VISTA.MENU.Menu;

/**
 *
 * @author Leo
 */
public class MainClass {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here
        
        if (Servicios.getInstancia().DEBUG())
        {
          Conexion db = Servicios.getInstancia().DB();
          db.testSqlSelect();
        }
        
        ControladorNegocio cn = new ControladorNegocio();
        new Menu(cn).setVisible(true);
        
        
        
        
    }
    
}
