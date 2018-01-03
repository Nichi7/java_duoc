/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA.MENU.CRUD.Chocolate;


import MODELO.NEGOCIO.Chocolate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author lhernandez
 */
 public class ModelJTableChocolate extends AbstractTableModel{
        private boolean DEBUG = true;
    
        //int colIndex=0;
        private List<String> cols = new ArrayList<String>();
        private ArrayList rows = new ArrayList();
        //private List<RowData> rows = new ArrayList<RowData>();

        public void setRows(ArrayList a)
        {
            this.rows = a;
            this.fireTableRowsUpdated(0, rows.size());
        }
        
        public ArrayList getRows()
        {
            return this.rows;
        }        
        
        public ModelJTableChocolate()
        {
            cols.add("Codigo");
            cols.add("Nombre");
            cols.add("Descripcion");
            cols.add("Precioventa");
            cols.add("Cantidad");
            cols.add("Tipocolor");
            cols.add("Tiposabor");
            cols.add("Marca");
            cols.add("azucar");

            /*
            Chocolate m1 = new Chocolate();
            m1.setNombre("leo");
            m1.setEdad(42);
            m1.setEstudia(false);
            
            Chocolate m2 = new Chocolate();
            m2.setNombre("Roxana");
            m2.setEdad(38);
            m2.setEstudia(true);
            
            //RowData r1 = new RowData();
            //r1.setValueForCol(m1, 0);
            rows.put(0, m1);
            //rows.add(0, r1);
            
            //RowData r2 = new RowData();
            //r2.setValueForCol(m1, 0);
            rows.put(1,m2);
            //rows.add(1, r2);
            */         
        }
        
        /*
        @Override
        public Class getColumnClass(int col) {
                if (col == 0 || col == 1)
                        return String.class;
                else
                        return null;
        }
        */

        //by leo ok
        @Override
        public int getColumnCount() {
            int t = cols.size();
            return t;
        }

        
        //by leo ok
        @Override
        public int getRowCount() {
            return rows.size();
        }
        

        //by leo ok
        @Override
        public String getColumnName(int column) {
            return cols.get(column).toString();
        }


        //by leo ok
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            //return this.data.get(row)[col];
            Chocolate m = (Chocolate)rows.get(rowIndex);
            
            Object o = null;
            
            if (columnIndex==0)
            {
                o=m.getCodigo();
            }
            if (columnIndex==1)
            {
                o=m.getNombre();
            }
            if (columnIndex==2)
            {
                o=m.getDescripcion();
            }
            if (columnIndex==3)
            {
                o=m.getPrecioventa();
            }
            if (columnIndex==4)
            {
                o=m.getCantidad();
            }
            if (columnIndex==5)
            {
                o=m.getTipocolor();
            }
            if (columnIndex==6)
            {
                o=m.getTiposabor();
            }
            if (columnIndex==7)
            {
                o=m.getMarca();
            }
            if (columnIndex==8)
            {
                o=m.isAzucar();
            }
            
            
            return o;
            //bject o = rowData.getValueForCol(cols.get(columnIndex));
            //turn o;
        }

        
        public Class getColumnClass(int c)
        {
            Object o = null;
            try
            {
               o = this.getValueAt(0, c);
               if (o!=null)
               {
                  return o.getClass(); 
               }
               
            }
            catch(NullPointerException e)
            {
                System.out.println(e.getMessage());
                return null;
            }
            return null;
        }
        
        
        //by leo ok
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }


        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            if (DEBUG) {
                if (rows.size()!=0)
                {
                 System.out.println("Seteando el valor en FILA:" + rowIndex + ", COLUMNA:" + columnIndex
                                   + " a '" + value
                                   + "' (una instancia de "
                                   + value.getClass() + ")");
                }
                else
                {
                    System.out.println("No hay registros en el modelo que imprimir.");
                }
            }
    
            
            Chocolate m = (Chocolate)rows.get(rowIndex);
            //if (rows.containsKey(rowIndex))
            //{
                if (columnIndex==0)
                {
                    m.setCodigo((int) value);
                }
                if (columnIndex==1)
                {
                    m.setNombre((String) value);
                }
                if (columnIndex==2)
                {
                    m.setDescripcion((String) value);
                }
                if (columnIndex==3)
                {
                    m.setPrecioventa((int) value);
                }
                if (columnIndex==4)
                {
                    m.setCantidad((int) value);
                }
                if (columnIndex==5)
                {
                    m.setTipocolor((String) value);
                }
                if (columnIndex==6)
                {
                    m.setTiposabor((String) value);
                }
                if (columnIndex==7)
                {
                    m.setMarca((String) value);
                }
                if (columnIndex==8)
                {
                    m.setAzucar((Boolean) value);
                }
            //}
            
            this.fireTableCellUpdated(rowIndex, columnIndex);
            this.fireTableDataChanged();
            if (DEBUG) {
                System.out.println("Nuevos valores de los datos despues de la ejecucion de los listeners:");
                printDebugData();
            }
        }

        
   
        
        public void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
            Calendar calendario = Calendar.getInstance();
            int hora;
            int minutos;
            int segundos;
            
            hora =calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE); 
            segundos = calendario.get(Calendar.SECOND);
            
            System.out.println("HORA:  "+ hora + ":" + minutos + ":" + segundos);
                        
            for (int i=0; i < numRows; i++) {
                //System.out.print("    row " + i + ":");
                //for (int j=0; j < numCols; j++) {
                    Chocolate m = (Chocolate)rows.get(i);
                    System.out.println("Registro #"+ i + " " + m.toString());
                //}
                //System.out.println();
            }
            System.out.println("--------------------------------------------------------------------------");
        }
        

        public void addRow() {
            int inicio = rows.size();
            this.rows.add(new Chocolate());
            fireTableRowsInserted(inicio, rows.size());
        }


        public void removeRow(int selectedRow) {
            rows.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }

        public void removeColumn(int selectedColumn) {
            cols.remove(selectedColumn);
            //List<Integer> remove = cols.remove(table.convertColumnIndexToModel(selectedColumn));
            fireTableStructureChanged();
        }

        public void addColumn() {
            //cols.add(++colIndex);
            fireTableStructureChanged();
        }


       

        //by leo ok
        /*
        public void setValueAt(String aValue, int rowIndex, int columnIndex) {
            //data.get(row)[col] = value;
            //fireTableCellUpdated(row, col);
            Modelo m = rows.get(rowIndex);
            if (rows.containsKey(rowIndex))
            {
                
                if (columnIndex==0)
                {
                    m.setNombre(aValue);
                }
                if (columnIndex==1)
                {
                    m.setEdad(Integer.parseInt(aValue));
                }    
            }
            else
            {
                //rows.put(rowIndex, m);
                //rows.putIfAbsent(rowIndex, aValue);
            }
            //RowData rowData = rows.get(rowIndex);
            //rowData.setValueForCol(aValue,cols.get(columnIndex));
            fireTableCellUpdated(rowIndex, columnIndex);
            
            
        }
*/
        
        //getData
        
        //setData
    }