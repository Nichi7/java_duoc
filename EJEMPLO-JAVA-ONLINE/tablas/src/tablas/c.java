/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniela
 */
public class c extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();//objeto de clase table

    public c() {
        initComponents();

        try {

            jtProductos.setModel(modelo); //llamamos la variable jtproducto y le agregamos el modelo

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT codigo, nombre, precio, cantidad FROM producto ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData(); //pasando resultado de la consulta
            int cantidadColumnas = rsmd.getColumnCount();//retorna la cantidad de columnas

            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");

            //agregar ancho a las columnas de la tabla
            int[] anchos = {50, 200, 50, 50};

            for (int x = 0; x < cantidadColumnas; x++) {
                jtProductos.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {
                //se crea un arreglo de objetos , de tamaño determinado por la var cantidad columnas
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1); //obtienen los resultados de una fila

                }
                modelo.addRow(filas); //estamos agregando las filas a la tabla
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Cantidad:");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        txtid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(btnguardar))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtnombre)
                                    .addComponent(txtprecio)
                                    .addComponent(txtcantidad))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnmodificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(btneliminar)
                                .addGap(33, 33, 33))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmodificar)
                            .addComponent(btneliminar)
                            .addComponent(btnguardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(56, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion objcon = new Conexion();
            Connection con = objcon.getConexion();

            int Fila = jtProductos.getSelectedRow(); //obtiene la fila que hemos seleccionado
            String codigo = jtProductos.getValueAt(Fila, 0).toString();
            //nos trae el valor de la column 0 que seria el codigo

            ps = con.prepareStatement("SELECT codigo, nombre, precio,cantidad FROM producto WHERE codigo=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtcodigo.setText(rs.getString("codigo"));
                txtnombre.setText(rs.getString("nombre"));
                txtprecio.setText(rs.getString("precio"));
                txtcantidad.setText(rs.getString("cantidad"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_jtProductosMouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      PreparedStatement ps = null;
       

        try {
            Conexion objcon = new Conexion();
            Connection con = objcon.getConexion();  
            ps = con.prepareStatement("INSERT INTO producto (codigo, nombre, precio, cantidad) VALUES (?,?,?,?)");  
            ps.setString(1, txtcodigo.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtprecio.getText());
            ps.setString(4, txtcantidad.getText());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto Guardado");
            Object [] fila = new Object[4];
            fila[0] = txtcodigo.getText();
            fila[1] = txtnombre.getText();
            fila[2] = txtprecio.getText();
            fila[3] = txtcantidad.getText();
            
            modelo.addRow(fila);
            
        }catch (SQLException e){
          JOptionPane.showMessageDialog(null, "Error al guardar producto");
            System.out.println(e);
            
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
     PreparedStatement ps = null;
       

        try {
            Conexion objcon = new Conexion();
            Connection con = objcon.getConexion();  
            
            int fila = jtProductos.getSelectedRow();
            String codigo = jtProductos.getValueAt(fila, 0).toString();
            
            ps = con.prepareStatement("DELETE FROM producto WHERE codigo=?");  
            ps.setString(1, codigo);
            ps.execute();
            
            modelo.removeRow(fila);
            
        }catch (SQLException e){
          
            System.out.println(e.toString());
            
        } 
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
         PreparedStatement ps = null;
       

        try {
            Conexion objcon = new Conexion();
            Connection con = objcon.getConexion();  
                    
            ps = con.prepareStatement("UPDATE producto SET codigo=? nombre=?, precio=?, cantidad=? WHERE id=?");   
              ps.setString(1, txtcodigo.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtprecio.getText());
            ps.setString(4, txtcantidad.getText());
            ps.setString(5, txtid.getText());
            
            
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
            Object [] fila = new Object[4];
            fila[0] = txtcodigo.getText();
            fila[1] = txtnombre.getText();
            fila[2] = txtprecio.getText();
            fila[3] = txtcantidad.getText();
            
            modelo.addRow(fila);
            
        }catch (SQLException e){
          JOptionPane.showMessageDialog(null, "Error al actualizar producto");
            System.out.println(e);
            
        }
        
        
    }//GEN-LAST:event_btnmodificarActionPerformed

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
            java.util.logging.Logger.getLogger(c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new c().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
