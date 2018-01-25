/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Tabla.Tabla;
import javax.swing.JButton;

/**
 *
 * @author David
 */
public class Visual extends javax.swing.JFrame {

   //creo un objeto tipo clase Tabla, intancio clase Tabla
    
    Tabla t = new Tabla();
    int rown = -1;
    
    public Visual() {
        initComponents();
        //llamo al metodo que trae como parametro una tabla
        t.visualizar(tabla);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar jCheckBox a jTable de Java");

        tabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
        rown = tabla.rowAtPoint(evt.getPoint());
        //obtenemos la posicion x e y de donde hacemos click, este dentro del rango de la tabla
        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tabla.getRowHeight();
        //el click esta dentro de la tabla
        if(row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0){
            Object value = tabla.getValueAt(row, column);
            //si donde hemos hecho click es un boton, devolvemos ese click
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                   //se toman los valores de la columna 0,1,2,3,4
                String va1 = ""+tabla.getValueAt(rown, 0);
                String va2 = ""+tabla.getValueAt(rown, 1);
                String va3 = ""+tabla.getValueAt(rown, 2);
                String va4 = ""+tabla.getValueAt(rown, 3);
                String va5 = ""+tabla.getValueAt(rown, 4);
                
                if(boton.getName().equals("v")){
                     try{
                        //y los mostramos en el jtextarea 
                        this.jTextArea1.setText("");
                        this.jTextArea1.append("id_Producto: "+va1);
                        this.jTextArea1.append("/nNombre Producto: "+va2);
                        this.jTextArea1.append("/nPrecio Producto: "+va3);
                        this.jTextArea1.append("/nMarca Producto:"+va4);
                        this.jTextArea1.append("/nActivo: "+va5);
                        
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                     }
                    
                }
            }
 

        }
        
    }//GEN-LAST:event_tablaMouseClicked

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
