/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniela
 */
public class Tabla {
    
    //se crea una metodo llamado ver tabla, que tiene como argumento un JTABLE
    public void ver_table (JTable tabla) {
        
        tabla.setDefaultRenderer(Object.class,new Render());
        //agregamos botones
        JButton btn1 = new JButton("Modificar");
        btn1.setName("m");// se coloca nombre o identificador al boton
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        //se crea estructura de la tabla
        DefaultTableModel d = new DefaultTableModel(
                //se crea objeto con registros que iran en la tabla
                new Object[][]{{"1","Pedro", btn1, btn2},{"2","Juan",btn1,btn2},{"3","Rosa",btn1,btn2},{"4","Maria",btn1,btn2}},
                new Object [] {"Código","Nombre","Modificar","Eliminar"}// se crea cabecera
        )
        {
            @Override
            //metodo para que las   celdas de la tabla no sean editables
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }       ;
        // se pasa el modelo a la tabla
        tabla.setModel(d);//setea el modelo anterior
        tabla.setRowHeight(30);//altura de las filas
        tabla.setBackground(Color.green);//setea color de fondo
       
        
    }
    
}
