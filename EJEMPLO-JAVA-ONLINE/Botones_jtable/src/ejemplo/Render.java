/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;



import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
//redenterizar la tabla
public class Render extends DefaultTableCellRenderer{
//genera automaticamente el metodo
    @Override
    public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // si el dato que le asignamos es un boton, entonces agrega boton y retorna un boton a la table
            if( value instanceof JButton) {
                //button puede ser modificado por un Jlabel, Jcombobox según necesitades
                JButton btn = (JButton)value;
                return btn;
                //sirve para mostrar un boton en una tabla JTABLA
                
            }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }
    //crea un metodo
   
    
    
}
