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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniela
 */
public class Barras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigos.pdf"));
            //sino se menciona la ruta que se guarde el pdf se guardara en el archivo proyecto
            doc.open();
            
            Barcode39 code = new Barcode39();// se crea el objeto o instancia codigo
            code.setCode("123456789");//se ingresa el valor del codigo
            //convertir el codigo en una imagen de codigo de barra
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
                   /* par1 donde se quedara (pdf),  par2 el color del codigo de barra,
                    par3 color de la letras*/
            doc.add(img);//se agrega la imagen al documento
            
            doc.add(new Paragraph(" "));//hacer un salto de linea para el documento
            
            Barcode128 code128 = new Barcode128();//crea codigo del tipo code128
            code128.setCode("123456789");
            //convertir el codigo en una imagen de codigo de barra
            Image img128 = code128.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            img128.scalePercent(200);//cambio de tamaño del codigo
            doc.add(img128);
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Barras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
