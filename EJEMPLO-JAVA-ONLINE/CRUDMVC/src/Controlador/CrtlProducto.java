/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.FrmProd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
public class CrtlProducto implements ActionListener {

    private Producto mod;
    private ConsultasProducto modc;
    private FrmProd frm;

    public CrtlProducto(Producto mod, ConsultasProducto modc, FrmProd frm) {
        this.mod = mod;
        this.modc = modc;
        this.frm = frm;
        this.frm.btnguardar.addActionListener(this);
        this.frm.btnmodificar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
        this.frm.btnlimpiar.addActionListener(this);
        this.frm.btnbuscar.addActionListener(this);
    }

    public void iniciar() {
        //coloca titulo a la ventana
        frm.setTitle("Productos");
        //centraliza la ventana
        frm.setLocationRelativeTo(null);
        frm.txtid.setVisible(false);
    }

    //crear la funcion que realizara el boton
    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnguardar) {
            mod.setCodigo(frm.txtcodigo.getText());
            mod.setNombre(frm.txtnombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtprecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtcantidad.getText()));

            if (modc.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }

        }
        if (e.getSource() == frm.btnmodificar) {
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            mod.setCodigo(frm.txtcodigo.getText());
            mod.setNombre(frm.txtnombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtprecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtcantidad.getText()));

            if (modc.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }
        if (e.getSource() == frm.btneliminar) {
            mod.setId(Integer.parseInt(frm.txtid.getText()));

            if (modc.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }
        if (e.getSource() == frm.btnbuscar) {
            mod.setCodigo(frm.txtcodigo.getText());

            if (modc.buscar(mod)) {
                frm.txtid.setText(String.valueOf(mod.getId()));
                frm.txtcodigo.setText(mod.getCodigo());
                frm.txtnombre.setText(mod.getNombre());
                frm.txtprecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtcantidad.setText(String.valueOf(mod.getCantidad()));

            } else {
                JOptionPane.showMessageDialog(null, "No se registro");
                limpiar();
            }

        }
        if (e.getSource() == frm.btnlimpiar) {
            limpiar();

        }
    }


public void limpiar() {
        frm.txtid.setText(null);
        frm.txtcodigo.setText(null);
        frm.txtnombre.setText(null);
        frm.txtprecio.setText(null);
        frm.txtcantidad.setText(null);

    }

}
