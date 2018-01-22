/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CrtlProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.FrmProd;

/**
 *
 * @author daniela
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultasProducto modc = new ConsultasProducto();
        FrmProd frm = new FrmProd();
        CrtlProducto ctrl = new CrtlProducto(mod, modc, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
