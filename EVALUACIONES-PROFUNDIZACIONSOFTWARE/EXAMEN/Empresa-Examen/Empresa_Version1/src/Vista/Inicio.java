/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Registro;
import Modelo.Empleados;
import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaumento = new javax.swing.JButton();
        btneliminar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmsalir = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmmostrar = new javax.swing.JMenu();
        jmagregar = new javax.swing.JMenuItem();
        jmbuscar = new javax.swing.JMenuItem();
        jmmostra = new javax.swing.JMenuItem();
        jmredes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnaumento.setText("AUMENTAR SUELDO");
        btnaumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaumentoMouseClicked(evt);
            }
        });

        btneliminar1.setText("ELIMINAR (120.000)");
        btneliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminar1MouseClicked(evt);
            }
        });

        jmsalir.setText("Archivo");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmsalir.add(jMenuItem3);

        jMenuBar1.add(jmsalir);

        jmmostrar.setText("Editar");

        jmagregar.setText("Agregar");
        jmagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmagregarActionPerformed(evt);
            }
        });
        jmmostrar.add(jmagregar);

        jmbuscar.setText("Buscar");
        jmbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmbuscarActionPerformed(evt);
            }
        });
        jmmostrar.add(jmbuscar);

        jmmostra.setText("Mostrar");
        jmmostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmmostraActionPerformed(evt);
            }
        });
        jmmostrar.add(jmmostra);

        jmredes.setText("Redes");
        jmredes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmredesActionPerformed(evt);
            }
        });
        jmmostrar.add(jmredes);

        jMenuBar1.add(jmmostrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnaumento)
                .addGap(27, 27, 27)
                .addComponent(btneliminar1)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmagregarActionPerformed
        Agregar a = Agregar.getAgregar();
        a.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jmagregarActionPerformed

    private void jmbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmbuscarActionPerformed
        Buscar b = Buscar.getBuscar();
        b.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jmbuscarActionPerformed

    private void jmmostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmmostraActionPerformed
        Mostrar m = Mostrar.getMostrar();
        m.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmmostraActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jmredesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmredesActionPerformed
        Mostrar_redes mr = Mostrar_redes.getMostrar_redes();
        mr.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jmredesActionPerformed

    private void btnaumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaumentoMouseClicked
        Registro g = new Registro();
        Empleados em = new Empleados();
        g.aumento();// TODO add your handling code here:
    }//GEN-LAST:event_btnaumentoMouseClicked

    private void btneliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminar1MouseClicked
        Registro g = new Registro();
        Empleados m = new Empleados();
        if(g.eliminar1()){
        JOptionPane.showMessageDialog(this, "Se han eliminado correctamente los empleados cuyo sueldo es $120.000");
        }else {
          JOptionPane.showMessageDialog(this, "No encuentra Empleados cuyo sueldo sea igual a $120.000");  
        }
    }//GEN-LAST:event_btneliminar1MouseClicked

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaumento;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jmagregar;
    private javax.swing.JMenuItem jmbuscar;
    private javax.swing.JMenuItem jmmostra;
    private javax.swing.JMenu jmmostrar;
    private javax.swing.JMenuItem jmredes;
    private javax.swing.JMenu jmsalir;
    // End of variables declaration//GEN-END:variables
}