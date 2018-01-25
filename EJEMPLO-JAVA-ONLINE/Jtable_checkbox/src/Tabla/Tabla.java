/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import DAO.ProductoDAO;
import Render.Render;
import VO.ProductoVO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//esta clase se encarga de crear el diseño de la tabla
public class Tabla {
    
    //este metodo indica que columnnas seran o no editable, una editable el check box
    private boolean[] editable = {false,false,false,false,true,false};
    //se declara objeto de clase Producto DAO
    ProductoDAO dao;
    
    public void visualizar(JTable tabla){
        //llamamos al renderizado para agregar boton y checkbox
        tabla.setDefaultRenderer(Object.class, new Render());
        //inicializamos las columnas
        DefaultTableModel dt = new DefaultTableModel(new String[]{"id_Producto", "nombre_prod", "precio", "marca", "activo","Visualizar"}, 0) {
         //declaramos el tipo de datos de cada columnas
            Class[] types = new Class[]{
                
                //object class es cualquier tipo de clase, la quinta fila es de tipo boolean
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
            };
            //retorna los tipos de datos de las columnas
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            //retorna las comunas si son o no editables
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        };
        //se crea un boton visualizar y crea un nombre
        JButton btn_visualizar = new JButton("Visualizar");
        btn_visualizar.setName("v");
        
        //creamos el objeto dao
        dao = new ProductoDAO();
        //declaramos y creamos el objeto ProductoVO
        ProductoVO vo = new ProductoVO();
        //crea objeto de tipo arraylist con objetos de ipo ProductoVO, y se llama al metodo Listar_Productos
        ArrayList<ProductoVO> list = dao.Listar_ProductoVO();

        if(list.size() > 0){//si el arreglo o list tiene elementos
            //se recorre los elementos del arreglo list
        for(int i=0; i< list.size(); i++){
            //se crea objeto tipo objeto con 6 elementos
        Object fila[] = new Object[6];
        vo = list.get(i);
        //se empiezan a obtener los datos
        fila[0] = vo.getId_Producto();
        fila[1] = vo.getNombre_prod();
        fila[2] = vo.getPrecio();
        fila[3] = vo.getMarca();
        int ac = (int) vo.getActivo();
        if(ac == 1) fila[4] = true;
        else fila[4] = false;
        fila[5] = btn_visualizar;
        //se agrega cada fila a la comuna
        dt.addRow(fila);
        
        }
        
        }
        //se agrega modelo de la tabla
        tabla.setModel(dt);
    
    }
    
}
