/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA.MENU.CRUD.Chocolate;

import CONTROLADOR.NEGOCIO.ControladorVentana;
import MODELO.DAO.ChocolateDAO;
import MODELO.NEGOCIO.Chocolate;
import MODELO.NEGOCIO.Chocolates;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Leo
 */
public class ControladorCRUDChocolate implements ControladorVentana
{
    
    //ModelJTablePersona m = new ModelJTablePersona();
    
    public ArrayList listar() throws Exception
    {
        Chocolates ps = new Chocolates();
        return ps.listarChocolates();
    }
    


    @Override
    public void agregar(Object o) throws Exception
    {
        Chocolate ch = (Chocolate)o;
        ChocolateDAO pDAO = new ChocolateDAO(ch);
        pDAO.create();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object o) throws Exception {
        Chocolate ch = (Chocolate)o;
        ChocolateDAO pDAO = new ChocolateDAO(ch);
        pDAO.delete();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Object o) throws Exception {
        Chocolate ch = (Chocolate)o;
        ChocolateDAO pDAO = new ChocolateDAO(ch);
        pDAO.update();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
