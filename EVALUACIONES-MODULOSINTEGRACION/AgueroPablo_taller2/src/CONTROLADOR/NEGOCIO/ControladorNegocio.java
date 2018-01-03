/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR.NEGOCIO;

import MODELO.NEGOCIO.Chocolate;
import MODELO.NEGOCIO.Chocolates;
import VISTA.MENU.CRUD.Chocolate.ControladorCRUDChocolate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leo
 */
public class ControladorNegocio {
    ControladorVentana cv = null;
    
    public void setControladorVentana(ControladorVentana uncv)
    {
        this.cv = uncv;
    }
    
    //INICIO-CRUD CHOCOLATES------------------------------------------------------
    public ArrayList listarChocolates() throws Exception
    {
        return this.cv.listar();
    }
    
    public void agregarChocolate(Chocolate ch) throws Exception
    {
        this.cv.agregar(ch);
    }
    
    public void eliminarChocolate(Chocolate ch)  throws Exception
    {
        this.cv.eliminar(ch);
    }
    
    public void actualizarChocolate(Chocolate ch) throws Exception
    {
        this.cv.actualizar(ch);
    }
    
    //FIN-CRUD CHOCOLATES---------------------------------------------------------
}
