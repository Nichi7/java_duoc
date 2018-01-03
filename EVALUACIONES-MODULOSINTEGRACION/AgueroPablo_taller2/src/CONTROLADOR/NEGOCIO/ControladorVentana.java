/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR.NEGOCIO;

import MODELO.NEGOCIO.Chocolate;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public interface ControladorVentana {
    
    public ArrayList listar() throws Exception;
    public void agregar(Object o) throws Exception;
    public void eliminar(Object o) throws Exception;
    public void actualizar(Object o) throws Exception;
}
