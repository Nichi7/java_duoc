/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barras;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

/**
 *
 * @author daniela
 */
public class BarrasMysql {
    public static void main(String agrs[]){
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Image img;
        
        Conexion conn = new Conexion();
        con = conn.getConexion();
        
        try {
            ps = con.prepareStatement("SELECT * FROM tienda1.producto");
            rs = ps.executeQuery();
            
                    
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigos.pdf"));
            //sino se menciona la ruta que se guarde el pdf se guardara en el archivo proyecto
            doc.open();
            
            Barcode39 code = new Barcode39();// se crea el objeto o instancia codigo
            
            while(rs.next()){
            code.setCode(rs.getString("codigo"));//se ingresa el valor del codigo dinamico desde bd
            //convertir el codigo en una imagen de codigo de barra
            img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
                   /* par1 donde se quedara (pdf),  par2 el color del codigo de barra,
                    par3 color de la letras*/
            doc.add(img);//se agrega la imagen al documento
            
            doc.add(new Paragraph(" "));//hacer un salto de linea para el documento
               
            }
            
            
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BarrasMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
