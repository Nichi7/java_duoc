/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Registro;
import Modelo.Categoria;
import Modelo.Pelicula;
import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
public class Buscar extends javax.swing.JFrame {

    private static Buscar b = null;

    public static Buscar getBuscar() {
        if (b == null) {
            b = new Buscar();
        }
        return b;
    }

    /**
     * Creates new form Buscar
     */
    public Buscar() {
        initComponents();
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        Registro r = new Registro();
        for (Categoria c : r.getCategoria()) {
            cbkcategoria2.addItem(c);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        chbformato2 = new javax.swing.JCheckBox();
        txtcodigo2 = new javax.swing.JTextField();
        txtnombre2 = new javax.swing.JTextField();
        txtprecio2 = new javax.swing.JTextField();
        cbkcategoria2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnlimpiar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código    :");

        jLabel2.setText("Nombre  :");

        jLabel3.setText("Precio     :");

        btnbuscar.setText("Buscar");
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnactualizarMouseClicked(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarMouseClicked(evt);
            }
        });

        chbformato2.setText("Formato4k");

        txtcodigo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigo2KeyReleased(evt);
            }
        });

        txtnombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombre2KeyReleased(evt);
            }
        });

        txtprecio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecio2KeyReleased(evt);
            }
        });

        jLabel4.setText("Categoria");

        jLabel6.setText("Nota: 1. El  Código de la Pelicula debe ser un número entre 10000 y 99999 ");

        jLabel7.setText("2. El nombre de la película debe tener 3 carácteres mínimo");

        jLabel8.setText("3. El precio de la película debe ser mayo a 1000");

        jLabel5.setText("4. El código de la pelicula no se puede modificar");

        btnlimpiar2.setText("Limpiar Casilla");
        btnlimpiar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnactualizar)
                            .addComponent(txtprecio2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chbformato2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btneliminar)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(cbkcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnlimpiar2)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(53, 53, 53)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnbuscar)
                    .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbformato2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbkcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnactualizar)
                    .addComponent(btnlimpiar2))
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void vaciar() {
        txtcodigo2.setText("");
        txtnombre2.setText("");
        txtprecio2.setText("");
        cbkcategoria2.setSelectedIndex(0);
        chbformato2.setSelected(false);

    }

    private void verifica(javax.swing.JTextField t) {
        String teclado = t.getText();
        if (teclado.length() > 0) {
            char tecla = teclado.charAt(teclado.length() - 1);
            teclado = teclado.substring(0, teclado.length() - 1);
            if (!Character.isDigit(tecla)) {
                t.setText(teclado);
            }
        }
    }
    private void verifica1(javax.swing.JTextField t) {
        String teclado = t.getText();
        if (teclado.length() > 0) {
            char tecla = teclado.charAt(0);
            teclado = teclado.substring(0, teclado.length() - 1);
            if (!Character.isLetter(tecla)) {
                t.setText(teclado);
                JOptionPane.showMessageDialog(this, "La PRIMERA letra del nombre de la película solo acepta letras del alfabeto español");
            }
        }

    }
    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        if (txtcodigo2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta Ingresar Còdigo para la Busqueda");
            return;
        }

        int codigo = Integer.parseInt(txtcodigo2.getText());
        Registro r = new Registro();
        Pelicula p = r.buscar(codigo);

        if (p == null) {
            JOptionPane.showMessageDialog(this, "Película No Encontrada");
            btnactualizar.setEnabled(false);
            btneliminar.setEnabled(false);
        } else {
            txtnombre2.setText(p.getNombre());
            txtnombre2.setCaretPosition(0);
            txtprecio2.setText("" + p.getPrecio());
            for (int i = 0; i < cbkcategoria2.getItemCount(); i++) {
                if (cbkcategoria2.getItemAt(i).getCodigo()==p.getCategoria()) {
                    cbkcategoria2.setSelectedIndex(i);
                    /*if (cbkcategoria2.getItemAt(i).equals(p.getCategoria())) {
                    cbkcategoria2.setSelectedIndex(i);*/
                    break;
                }

            }

            if (p.getFormato4k().equals("S")) {
                chbformato2.setSelected(true);
            } else if (p.getFormato4k().equals("N")) {
                chbformato2.setSelected(false);
            }

            btnactualizar.setEnabled(true);
            btneliminar.setEnabled(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void btnactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizarMouseClicked
        if (txtnombre2.getText().isEmpty()
                || txtcodigo2.getText().isEmpty()
                || txtprecio2.getText().isEmpty()
                || (cbkcategoria2.getSelectedItem().toString().equals("Seleccione"))) {
            JOptionPane.showMessageDialog(this, "Faltan Datos por Ingresar");
            return;
        }
        if ((Integer.parseInt(txtcodigo2.getText()) < 10000) || (Integer.parseInt(txtcodigo2.getText()) > 99999)) {
            JOptionPane.showMessageDialog(this, "El Código de la Película debe ser un número entre 10000 y 99999");
            return;
        }
        if ((Integer.parseInt(txtprecio2.getText()) < 1001)) {
            JOptionPane.showMessageDialog(this, "El Precio de la Película debe ser mayor a $1.000");
            return;
        }
        String largonom = txtnombre2.getText();
        if (largonom.length() < 3) {
            JOptionPane.showMessageDialog(this, "El nombre de la Película no debe tener menos de 3 caráteres");
        }
        Pelicula p = new Pelicula();
        p.setPrecio(Integer.parseInt(txtprecio2.getText()));
        p.setNombre(txtnombre2.getText());
        Categoria categ = (Categoria) cbkcategoria2.getSelectedItem();
        p.setCategoria(categ.getCodigo());

        if (chbformato2.isSelected()) {
            p.setFormato4k("S");
        } else {
            p.setFormato4k("N");
        }
        p.setCodigo(Integer.parseInt(txtcodigo2.getText()));
        Registro g = new Registro();
        JOptionPane.showMessageDialog(this, g.actualizar(p));

        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
    }//GEN-LAST:event_btnactualizarMouseClicked

    private void btneliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseClicked
        if (!btneliminar.isEnabled()) {
            return;
        }
        int codigo = Integer.parseInt(txtcodigo2.getText());
        Registro r = new Registro();
        r.eliminar(codigo);
        JOptionPane.showMessageDialog(this, "Película eliminada Correctamente");

        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
    }//GEN-LAST:event_btneliminarMouseClicked

    private void txtprecio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecio2KeyReleased
        verifica(txtprecio2);        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecio2KeyReleased

    private void txtcodigo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigo2KeyReleased
        verifica(txtcodigo2);        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo2KeyReleased

    private void btnlimpiar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiar2MouseClicked
        vaciar();   
        txtcodigo2.requestFocus(); //posicionar el curso en la casilla codigo
    }//GEN-LAST:event_btnlimpiar2MouseClicked

    private void txtnombre2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre2KeyReleased
     verifica1(txtnombre2);   // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre2KeyReleased

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
            java.util.logging.Logger.getLogger(Buscar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar2;
    private javax.swing.JComboBox<Categoria> cbkcategoria2;
    private javax.swing.JCheckBox chbformato2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtcodigo2;
    private javax.swing.JTextField txtnombre2;
    private javax.swing.JTextField txtprecio2;
    // End of variables declaration//GEN-END:variables
}