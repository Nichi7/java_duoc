/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Registro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import sql.Conexion;

/**
 *
 * @author daniela
 */
public class Mostrar extends javax.swing.JFrame {

    private static Mostrar t = null;

    public static Mostrar getMostrar() {
        if (t == null) {
            t = new Mostrar();
        }
        return t;
    }

    /**
     * Creates new form Mostrar
     */
    public Mostrar() {
        initComponents();
        //se crea formato de la tabla, cabecera y datos
        String cabecera[] = {"Cód.", "Rut", "Nombre", "Apellido", "Cel","Email","Sueldo","E_Civil","Depto"};
        String datos[][] = {};
        DefaultTableModel model;
        model = new DefaultTableModel(datos, cabecera);
        jtempleados.setModel(model);
        //crea el método
        /*try {
            //mostrar datos
            Connection conexion = Conexion.getConexion();
            Statement smt = conexion.createStatement();
            String query = "SELECT * FROM pelicula";
            ResultSet rs = smt.executeQuery(query);

     

            while (rs.next()) {
                //sacamos datos de grilla
                int codigo = rs.getInt("codigo");
                int precio = rs.getInt("precio");
                int categoria = rs.getInt("categoria");
                String formato4k = rs.getString("formato4k");
                String nombre = rs.getString("nombre");

                Object[] fila = new Object[]{codigo, precio, categoria, formato4k, nombre};
                model.addRow(fila);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtempleados = new javax.swing.JTable();
        btnmostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtempleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jtempleados.setToolTipText("");
        jScrollPane1.setViewportView(jtempleados);

        btnmostrar.setText("Mostrar");
        btnmostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmostrarMouseClicked(evt);
            }
        });
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Departamentos");

        jLabel2.setText("1. Informática");

        jLabel3.setText("2. Redes");

        jLabel4.setText("5. Bienestar");

        jLabel5.setText("4.  Finanza");

        jLabel6.setText("3. Administración");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnmostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnmostrar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btnmostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmostrarMouseClicked
        String cabecera[] = {"Cód.", "Rut", "Nombre", "Apellido", "Cel","Email","Sueldo","E_Civil","Depto"};
        String datos[][] = {};
        DefaultTableModel model;
        model = new DefaultTableModel(datos, cabecera);
        jtempleados.setModel(model);
        //crea el método
        try {
            //mostrar datos
            Connection conexion = Conexion.getConexion();
            Statement smt = conexion.createStatement();
            String query = "SELECT * FROM empleados";
            ResultSet rs = smt.executeQuery(query);

            /*DefaultTableModel model = (DefaultTableModel) tbsemilla.getModel();*/ //representa el formato de la tabla no la tabla en si 
            while (rs.next()) {
                //sacamos datos de grilla
                int cod = rs.getInt("codigo");
                String rut = rs.getString("rut");
                String nom = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cel = rs.getInt("celular");
                String mail = rs.getString("email");
                int sueldo = rs.getInt("sueldo_bruto");
                String e_civil = rs.getString("est_civil");
                String depto = rs.getString("nom_dept");
                //condicion que selecciona solo pelicula de categoria romance
                
                    Object[] fila = new Object[]{cod, rut, nom, apellido, cel,mail,sueldo,e_civil,depto};
                    model.addRow(fila);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnmostrarMouseClicked

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
            java.util.logging.Logger.getLogger(Mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtempleados;
    // End of variables declaration//GEN-END:variables
}
