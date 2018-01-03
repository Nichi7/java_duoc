/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO.NEGOCIO;

import MODELO.DAO.ChocolatesDAO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Leo
 */
public class Chocolates {
    private ArrayList chocolates=null;
    
    public void Chocolates()
    {
    
    }
    
    public void setChocolates(ArrayList ch)
    {
        this.chocolates = ch;
    }
    
    public ArrayList getChocolates()
    {
        return chocolates;
    }
    
    public ArrayList listarChocolates() throws Exception
    {
        ChocolatesDAO chDAO = new ChocolatesDAO();
        return chDAO.read();
    }
    
}
