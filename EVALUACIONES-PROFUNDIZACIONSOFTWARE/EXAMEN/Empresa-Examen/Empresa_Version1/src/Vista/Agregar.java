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
 * @author Concepción
 */
public class Agregar extends javax.swing.JFrame {

    private static Agregar a = null;

    public static Agregar getAgregar() {
        if (a == null) {
            a = new Agregar();
        }
        return a;
    }

    /**
     * Creates new form Agregar
     */
    public Agregar() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtrut = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        rbncasado = new javax.swing.JRadioButton();
        rbnsoltero = new javax.swing.JRadioButton();
        rbnviudo = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        cbxdepto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código    :");

        jLabel2.setText("Nombre   :");

        jLabel4.setText("Celular   :");

        jLabel5.setText("Estado Civil");

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcelularKeyReleased(evt);
            }
        });

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        btnagregar.setText("Agregar");
        btnagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnagregarMouseClicked(evt);
            }
        });
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nota: 1. El  Código de la Pelicula debe ser mayor a cero y menor o igual a 100");

        jLabel7.setText("2. El Sueldo bruto debe ser mayor o igual a  $120.000");

        btnlimpiar.setText(" Limpiar Casillas");
        btnlimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("INGRESO EMPLEADOS");

        jLabel10.setText("Apellido:");

        txtapellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtapellidoMouseClicked(evt);
            }
        });
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoKeyReleased(evt);
            }
        });

        jLabel11.setText("RUT     :");

        txtrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrutKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrutKeyTyped(evt);
            }
        });

        jLabel12.setText("Email    :");

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });

        jLabel13.setText("Sueldo   :");

        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsueldoKeyReleased(evt);
            }
        });

        buttonGroup1.add(rbncasado);
        rbncasado.setText("Casado");
        rbncasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbncasadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnsoltero);
        rbnsoltero.setText("Soltero");

        buttonGroup1.add(rbnviudo);
        rbnviudo.setText("Viudo");

        jLabel14.setText("Departamento");

        cbxdepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Informática", "Redes", "Administración", "Finanzas", "Bienestar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7)
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbncasado))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnlimpiar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(27, 27, 27)
                                        .addComponent(cbxdepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(181, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbnviudo)
                            .addComponent(rbnsoltero))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnagregar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbncasado)
                            .addComponent(jLabel14)
                            .addComponent(cbxdepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbnsoltero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbnviudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlimpiar)
                        .addGap(27, 27, 27)))
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            char tecla = teclado.charAt(teclado.length() - 1);
            teclado = teclado.substring(0, teclado.length() - 1);
            if (tecla == ' ') {
                JOptionPane.showMessageDialog(this, "Un nombre no puede empezar por espacio");
            } else if (!Character.isLetter(tecla)) {
                t.setText(teclado);
                JOptionPane.showMessageDialog(this, "El nombre solo acepta letras del alfabeto español");
                return;
            }

        }

    }

    private void verifica2(javax.swing.JTextField t) {
        String teclado = t.getText();
        if (teclado.length() > 0) {
            char tecla = teclado.charAt(teclado.length() - 1);
            teclado = teclado.substring(0, teclado.length() - 1);
            if (tecla == ' ') {
                JOptionPane.showMessageDialog(this, "Un apellido no puede empezar por espacio");
            } else if (!Character.isLetter(tecla)) {
                t.setText(teclado);
                JOptionPane.showMessageDialog(this, "El apellido solo acepta letras del alfabeto español");
                return;
            }

        }

    }

    private void vaciar() {
        txtcodigo.setText("");
        txtrut.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcelular.setText("");
        txtsueldo.setText("");
        txtemail.setText("");
        cbxdepto.setSelectedIndex(0);
        /*rbncasado.setSelected(false);
        rbnsoltero.setSelected(false);
        rbnviudo.setSelected(false);*/
        buttonGroup1.clearSelection();
    }

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarMouseClicked
        if (txtnombre.getText().isEmpty()
                || txtrut.getText().isEmpty()
                || txtapellido.getText().isEmpty()
                || txtcodigo.getText().isEmpty()
                || txtemail.getText().isEmpty()
                || txtcelular.getText().isEmpty()
                || txtsueldo.getText().isEmpty()
                || (!rbncasado.isSelected() && !rbnsoltero.isSelected() && !rbnviudo.isSelected())
                || (cbxdepto.getSelectedItem().toString().equals("Seleccione"))) {
            JOptionPane.showMessageDialog(this, "Faltan Datos por Ingresar");
            return;
        }
        if ((Integer.parseInt(txtcodigo.getText()) < 0) || (Integer.parseInt(txtcodigo.getText()) > 100)) {
            JOptionPane.showMessageDialog(this, "El Código debe ser mayor a cero y menor o igual a 100");
            return;
        }
        if ((Integer.parseInt(txtsueldo.getText()) < 120000)) {
            JOptionPane.showMessageDialog(this, "El Sueldo debe ser mayor o igual a $120.000");
            return;
        }
        String largocel = txtcelular.getText();
        if (!(largocel.length() == 9)) {
            JOptionPane.showMessageDialog(this, "El número celular debe contener 9 dígitos");
            return;
        }

        Empleados p = new Empleados();
        p.setCodigo(Integer.parseInt(txtcodigo.getText()));
        p.setRut(txtrut.getText());
        p.setNombre(txtnombre.getText());
        p.setApellido(txtapellido.getText());
        p.setCelular(Integer.parseInt(txtcelular.getText()));
        p.setEmail(txtemail.getText());
        p.setSueldo(Integer.parseInt(txtsueldo.getText()));
        //metodo alternativo para ingresar en base de dato segun seleccion combobox la primera letra de cada string
        //p.setEstado(cbxestado.getSelectedItem().toString().chatAt(0));
        //metodo chaAt trae la letra de un String según posición indicada
        if (rbncasado.isSelected()) {
            p.setEstado("C");
        }
        if (rbnsoltero.isSelected()) {
            p.setEstado("S");
        }
        if (rbnviudo.isSelected()) {
            p.setEstado("V");
        }
        if (cbxdepto.getSelectedIndex() == 1) {
            p.setDepto("Informática");
        }
        if (cbxdepto.getSelectedIndex() == 2) {
            p.setDepto("Redes");
        }
        if (cbxdepto.getSelectedIndex() == 3) {
            p.setDepto("Administración");
        }
        if (cbxdepto.getSelectedIndex() == 4) {
            p.setDepto("Finanzas");
        }
        if (cbxdepto.getSelectedIndex() == 5) {
            p.setDepto("Bienestar");
        }

        Registro g = new Registro();
        JOptionPane.showMessageDialog(this, g.agregar(p));

    }//GEN-LAST:event_btnagregarMouseClicked

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased
        verifica(txtcodigo);

    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtcelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyReleased
        verifica(txtcelular);        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularKeyReleased

    private void btnlimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiarMouseClicked
        vaciar();
        txtcodigo.requestFocus(); //posicionar el curso en la casilla codigo
    }//GEN-LAST:event_btnlimpiarMouseClicked

    private void txtrutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrutKeyReleased
           // TODO add your handling code here:
    }//GEN-LAST:event_txtrutKeyReleased

    private void txtrutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrutKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrutKeyTyped

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailKeyReleased

    private void txtsueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyReleased
        verifica(txtsueldo);        // TODO add your handling code here:
    }//GEN-LAST:event_txtsueldoKeyReleased

    private void rbncasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbncasadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbncasadoActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        verifica1(txtnombre);        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtapellidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoMouseClicked

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased
        verifica2(txtapellido);        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoKeyReleased

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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxdepto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbncasado;
    private javax.swing.JRadioButton rbnsoltero;
    private javax.swing.JRadioButton rbnviudo;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrut;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
