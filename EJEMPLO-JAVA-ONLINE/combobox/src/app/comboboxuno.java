/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.estados;
import modelo.localidades;
import modelo.municipios;

/**
 *
 * @author daniela
 */
public class comboboxuno extends javax.swing.JFrame {

    public comboboxuno() {
        initComponents();

        estados cc = new estados();
        DefaultComboBoxModel modeloestado = new DefaultComboBoxModel(cc.mostrarEstados());
        cbxestado.setModel(modeloestado);

        /*PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        try {
            String sql = "SELECT *FROM t_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            cbxestado.addItem("Seleccione Estado");
            while(rs.next()){
                cbxestado.addItem(rs.getString("estado"));
                
            }
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxestado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxmunicipio = new javax.swing.JComboBox<>();
        cbxlocalidades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdato = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Estado:");

        cbxestado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxestadoItemStateChanged(evt);
            }
        });
        cbxestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxestadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Municipio:");

        jLabel3.setText("Localidades:");

        cbxmunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxmunicipioItemStateChanged(evt);
            }
        });

        cbxlocalidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxlocalidadesItemStateChanged(evt);
            }
        });

        txtdato.setColumns(20);
        txtdato.setRows(5);
        jScrollPane1.setViewportView(txtdato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxestado, 0, 243, Short.MAX_VALUE)
                            .addComponent(cbxlocalidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxmunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbxmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxlocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxestadoActionPerformed

    private void cbxestadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxestadoItemStateChanged
        //si se produjo este evento
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            estados est = (estados) cbxestado.getSelectedItem();
            municipios num = new municipios();
            DefaultComboBoxModel modmunicipio = new DefaultComboBoxModel(num.mostrarMunicipios(est.getId()));
            cbxmunicipio.setModel(modmunicipio);

            //adaptar modelo de una tabla ya prediseñada
            /*try 
           {
                 
            DefaultTableModel modelo = new DefaultTableModel();//objeto de clase table
            jtmunicipios.setModel(modelo); //llamamos la variable jtproducto y le agregamos el modelo

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT id_municipio, municipio FROM t_municipio WHERE t_estado_id_estado="+est.getId();
                    
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData(); //pasando resultado de la consulta
            int cantidadColumnas = rsmd.getColumnCount();//retorna la cantidad de columnas
            
            modelo.addColumn("ID");
            modelo.addColumn("Municipio");
            
            
            //agregar ancho a las columnas de la tabla
            int [] anchos = {50,200};
            
            for(int x= 0; x<cantidadColumnas;x++){
                jtmunicipios.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {
                //se crea un arreglo de objetos , de tamaño determinado por la var cantidad columnas
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1); //obtienen los resultados de una fila

                }
                modelo.addRow(filas); //estamos agregando las filas a la tabla
            }

        } catch (SQLException ex){
            System.err.println(ex.toString());
        }*/
        }
    }//GEN-LAST:event_cbxestadoItemStateChanged

    private void cbxlocalidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxlocalidadesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            estados est = (estados) cbxestado.getSelectedItem();
            municipios mun = (municipios) cbxmunicipio.getSelectedItem();
            localidades loc = (localidades) cbxlocalidades.getSelectedItem();
            txtdato.setText("Estado: "+est.getNombre()+ " Municipio: "+mun.getNombre()+" Localidad: "+loc.getNombre());
        }
    }//GEN-LAST:event_cbxlocalidadesItemStateChanged

    private void cbxmunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxmunicipioItemStateChanged
        municipios mun = (municipios) cbxmunicipio.getSelectedItem();
        localidades loc = new localidades();
        DefaultComboBoxModel modmunicipio = new DefaultComboBoxModel(loc.mostrarLocalidades(mun.getId()));
        cbxlocalidades.setModel(modmunicipio);
    }//GEN-LAST:event_cbxmunicipioItemStateChanged

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
            java.util.logging.Logger.getLogger(comboboxuno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(comboboxuno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(comboboxuno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(comboboxuno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new comboboxuno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxestado;
    private javax.swing.JComboBox<String> cbxlocalidades;
    private javax.swing.JComboBox<String> cbxmunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtdato;
    // End of variables declaration//GEN-END:variables
}
