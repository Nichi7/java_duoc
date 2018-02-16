/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class Reporte {
    
    public static void main(String args[])
    {
    reporte();
    }

    public static void reporte()  {

        //crear metodo crear reportes
        //crea un archivo
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Productos"); //se crea una viñeta en el libro de excel//se crea una viñeta en el libro de excel//se crea una viñeta en el libro de excel//se crea una viñeta en el libro de excel

        try {
            
            InputStream is = new FileInputStream("src\\img\\tienda.jpg"); 
                byte[] bytes = IOUtils.toByteArray(is);//transforma imagen en formato byte
                int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
                is.close();
             //transforma imagen en formato byte
            
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.getDrawingPatriarch();
            ClientAnchor anchor = help.createClientAnchor(); // indicar ancho de la imagen
            anchor.setCol1(0); //en que columna se posicionar la imagen
            anchor.setRow1(1);//en que fila se va a posicionar la imagen
            Picture pict = draw.createPicture(anchor, imgIndex);//se creara la imagen
            //cambiar el tamaño de la imagen
            //parametro de donde va a empezar y cuanto podra utilizar de espacio
            pict.resize(1,3);
            
            CellStyle tituloestilo = book.createCellStyle();
            tituloestilo.setAlignment(HorizontalAlignment.CENTER);//alineacio horizontal titulo
            tituloestilo.setVerticalAlignment(VerticalAlignment.CENTER);//alineacio vertical titulo
            Font fuentetitulo = book.createFont();
            fuentetitulo.setFontName("Arial");//asigna tipo de letra
            fuentetitulo.setBold(true);//negrita
            fuentetitulo.setFontHeightInPoints((short)14);//tamaño letra
            tituloestilo.setFont(fuentetitulo);//pasan el formato de estilo
            
            //crear la fila donde estara el titulo
            
            Row filatitulo = sheet.createRow(1);
            Cell celdatitulo = filatitulo.createCell(1);
            celdatitulo.setCellStyle(tituloestilo);
            celdatitulo.setCellValue("Reporte de Productos");
            //combinacion en varias celdas
            sheet.addMergedRegion(new CellRangeAddress(1,2,1,3));
            //se crea un arreglo con las cabeceras
            String[] cabecera = new String []{"Código","Nombre", "Precio", "Existencias", "Importe"};
            
            //se crea el estilo de la cabecera
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());//color de fondo
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//y tipo de relleno
            headerStyle.setBorderBottom(BorderStyle.THIN);//estilo borde superior
            headerStyle.setBorderLeft(BorderStyle.THIN);//estilo borde izquierdo
            headerStyle.setBorderRight(BorderStyle.THIN);//estilo borde derecho
            headerStyle.setBorderBottom(BorderStyle.THIN);//estilo borde inferior
            //se crea la fuente de la letra
            Font font = book.createFont();
            font.setFontName("Arial");//tipo de letra
            font.setBold(true);//negrita
            font.setColor(IndexedColors.WHITE.getIndex());//color de letra blanco
            font.setFontHeightInPoints((short) 12);//tamaño
            headerStyle.setFont(font);//se inserto al estilo de cabecera el formato de letra
            
            Row filaEncabezados = sheet.createRow(4);
            //imprimimos los titulos de las columnas de la cabecera con un for
            for (int i= 0; i<cabecera.length; i++){
                Cell celdaEncabezado = filaEncabezados.createCell(i);
                celdaEncabezado.setCellStyle(headerStyle);
                celdaEncabezado.setCellValue(cabecera[i]);
            
            }
            //agregar el contenido, conexion al mysql
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.getConexion();
            //desde que fila voy a trata el contenido
            
            int numFilaDatos = 5;
            //estilo celda con bordes
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            ps = conn.prepareStatement("SELECT codigo, nombre, precio, cantidad FROM producto");
            rs = ps.executeQuery();
            //utilizar varible para saber numero de columnas
            int numCol = rs.getMetaData().getColumnCount();
            while(rs.next()){//se recorre el resulset
                
                Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getDouble(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                Cell celdaImporte = filaDatos.createCell(4);
                celdaImporte.setCellStyle(datosEstilo);
                celdaImporte.setCellFormula(String.format("C%d+D%d", numFilaDatos + 1, numFilaDatos + 1));

                numFilaDatos++;

            }
            
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            
            sheet.setZoom(150);
                
            FileOutputStream fileout = new  FileOutputStream("ReporteProductos.xlsx");
            book.write(fileout);
            fileout.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }    
         catch (IOException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
