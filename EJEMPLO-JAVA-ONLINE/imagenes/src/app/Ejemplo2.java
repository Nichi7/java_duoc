/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Conexion;

/**
 *
 * @author daniela
 */
public class Ejemplo2 extends javax.swing.JFrame {

    /**
     * Creates new form Ejemplo
     */
    public Ejemplo2() {
        initComponents();
        //sacar tamaño del panel

        /*int x = jpimagen.getWidth();
        int y = jpimagen.getHeight();
        
        String archivo = "/img/manzana.jpg";
        //convertir la imagen y colocarla en el jpane
        //se crea la instancia de clase imagen y se le pasan los 3 parametros del contructor
        Imagen img = new Imagen(x, y, archivo);
        jpimagen.add(img); //agregar imagen en jpane
        jpimagen.repaint();*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpimagen = new javax.swing.JPanel();
        btncargar = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpimagenLayout = new javax.swing.GroupLayout(jpimagen);
        jpimagen.setLayout(jpimagenLayout);
        jpimagenLayout.setHorizontalGroup(
            jpimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        jpimagenLayout.setVerticalGroup(
            jpimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        btncargar.setText("Cargar");
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        btnmostrar.setText("Mostrar");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(btncargar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncargar)
                    .addComponent(btnmostrar))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed

        JFileChooser fc = new JFileChooser();
        //pueda seleccionar carpetas y/o archivos
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //creo filtro para que me entreguen el tipo de archivo que yo quiera, jpg
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg");
        // se agrega filtro al chooser
        fc.setFileFilter(filtro);
        //capturar lo que haya presionado el usuario

        int seleccion = fc.showOpenDialog(this);

        PreparedStatement ps;
        ResultSet rs;
        Conexion objcon = new Conexion();

        //validar si el usuario presiona aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //traer el archivo que he seleccionado
            File fichero = fc.getSelectedFile();
            //crear una ruta de este archivo
            String ruta = fichero.getAbsolutePath();//genero la ruta absoluta de este archivo
            //no voy utilizar, solo guardar imagen, no la voy a mostrar

            
        }

        
    }//GEN-LAST:event_btncargarActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        PreparedStatement ps;
        ResultSet rs;
        Conexion objcon = new Conexion();

        try {
            Connection con = objcon.getConexion();
            //traer la imagen

            ps = con.prepareStatement("SELECT imagen FROM datos WHERE id=?");
            ps.setInt(1, 1);
            rs = ps.executeQuery();

            BufferedImage buffin = null;
            byte[] image = null;
            //saco los resultado de la consulta
            while (rs.next()) {
                image = rs.getBytes("imagen");
                //conversion de mi imagen
                InputStream img = rs.getBinaryStream(1);
                try {
                    //realiza la conversion
                    buffin = ImageIO.read(img);
                    ImagenMySQL imagen = new ImagenMySQL(jpimagen.getHeight(), jpimagen.getWidth(), buffin);

                    jpimagen.add(imagen);
                    jpimagen.repaint();

                } catch (IOException ex) {
                    System.err.println(ex);

                }

            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());

        }


    }//GEN-LAST:event_btnmostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Ejemplo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejemplo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejemplo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejemplo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejemplo2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JPanel jpimagen;
    // End of variables declaration//GEN-END:variables
}
