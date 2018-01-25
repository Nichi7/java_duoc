/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        //instanciamos un boton
        /* si es un boton agregamos el boton*/
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){//se colocan alguna condiciones, el fondo del boton y el..
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        //instanciamos un checkbox
        if(value instanceof JCheckBox){
        /* si el objeto es un check box entonces agregamos el check box a la fila
            correspondiente*/
            
            JCheckBox ch = (JCheckBox)value;

            return ch;
        }
        //retorna el renderizado de la tabla
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); 
    }
    
}
