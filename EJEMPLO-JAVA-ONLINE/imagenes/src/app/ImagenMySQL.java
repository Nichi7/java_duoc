/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author daniela
 */
public class ImagenMySQL extends javax.swing.JPanel{
    BufferedImage ruta;
    // crear constructor que recibe ciertos pàrametros
    public ImagenMySQL ( int x, int y, BufferedImage ruta)
    {
       this.setSize(x,y);
       this.ruta = ruta;
       
    }
    //crear metodo, va a recibir un graphics
    public void paint(Graphics g)  {
        //conversion de la imagen
        
        Dimension height = getSize();//sacar la dimencion
        //ImageIcon img = new ImageIcon(getClass().getResource(ruta));//instancia de clase imagenicon
        //cambio codigo imagene externa
        //Image imgext = new ImageIcon(ruta).getImage();
        BufferedImage img = ruta;
        
       //dibujar la imagen se le envian algunos valores
       //parametros objeto img, unos ceros, los tamaños
       g.drawImage(img, 0, 0, height.width, height.height, null);
       //establecer que no sea opaca
       setOpaque(false);
       //indicamos la g para establecer ya la
       super.paintComponent(g);
       
       
        
        
    }

    
}
