/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author daniela
 */
public class Excel {

    public static void main(String[] args) {

        //crearExcel();
        //leer();
        //cargar();
        modificar();

    }
    // metodo para crear un libro en excel

    public static void crearExcel() {

        //vamos a crear dos tipos de archivo xls
        //llamar a clase
        //Workbook book = new HSSFWorkbook();informo que voy a crear archivo en excel version antigua .xls
        Workbook book = new XSSFWorkbook(); //nueva version
        org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Hola Java"); //crea una nueva pestaña
        //guardar archivo

        //crear fila primera y sus celdas
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Hola Mundo");//crea celta con un dato stream
        row.createCell(1).setCellValue(7.5);//crea celta con un dato double
        row.createCell(2).setCellValue(true);//crea celta con un dato boolean

        Cell celda = row.createCell(3); //agregarle mas atributos a una celda
        celda.setCellFormula(String.format("1+1", ""));
        //se crea fila segunda y sus celdas
        Row rowUno = sheet.createRow(1);
        rowUno.createCell(0).setCellValue(7);
        rowUno.createCell(1).setCellValue(8);

        Cell celdados = rowUno.createCell(2); //agregarle mas atributos a una celda
        celdados.setCellFormula(String.format("A%d+B%d", 2, 2));//celdas dinamicas
        //celdados.setCellFormula(String.format("A2+B2", ""));sumatoria de celdas estaticas

        try {
            //FileOutputStream fileout = new FileOutputStream("Excel.xls");
            FileOutputStream fileout = new FileOutputStream("Excel.xlsx");//se cambia extension
            book.write(fileout);//escribir archivo
            fileout.close();
            //este archivo se crea en el archivo de nuestro proyecto
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leer() {
        try {
            //llama al archivo a utilizar y se coloca ruta donde esta el archivo
            FileInputStream file = new FileInputStream(new File("C://Users/daniela/Desktop/TECNOLOGÍADANI/CURSO-PROGRAMACION-ONLINE/10-EXCEL-JAVA-MYSQL/productos.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 0; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                int numCols = fila.getLastCellNum();

                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    switch (celda.getCellTypeEnum().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;
                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;
                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }
                }
                System.out.println("");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cargar() {
        //crear objeto para la conexion
        Conexion con = new Conexion();//crear intancia clase conexion
        PreparedStatement ps; //variable guarda consulta sql
        try {
            Connection conn = con.getConexion();
            //llama al archivo a utilizar y se coloca ruta donde esta el archivo
            FileInputStream file = new FileInputStream(new File("C://Users/daniela/Desktop/TECNOLOGÍADANI/CURSO-PROGRAMACION-ONLINE/10-EXCEL-JAVA-MYSQL/productos.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {//se inicia en 1 para saltar la fila de encabezados
                Row fila = sheet.getRow(a);

                ps = conn.prepareStatement("INSERT INTO producto(codigo, nombre, precio, cantidad)"
                        + "VALUES (?,?,?,?)");
                ps.setString(1, fila.getCell(0).getStringCellValue());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setDouble(3, fila.getCell(2).getNumericCellValue());
                ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                ps.execute();

            }
            conn.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException e) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void modificar() {
        try {
            //llama al archivo a utilizar y se coloca ruta donde esta el archivo
            FileInputStream file = new FileInputStream(new File("C://Users/daniela/Desktop/TECNOLOGÍADANI/CURSO-PROGRAMACION-ONLINE/10-EXCEL-JAVA-MYSQL/productos.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
        //traer la fila
        XSSFRow fila = sheet.getRow(1);
        if(fila == null)//si no existe la primera fila
        {
            fila = sheet.createRow(1); //crea primera fila
            
        }
        XSSFCell celda = fila.createCell(1);
        if(celda == null){
            celda = fila.createCell(1);
        }
        //si existe la fila y la celda se puede ingresar ya un valor
        celda.setCellValue("Modificación");
        file.close();
        
        FileOutputStream output = new FileOutputStream("C://Users/daniela/Desktop/TECNOLOGÍADANI/CURSO-PROGRAMACION-ONLINE/10-EXCEL-JAVA-MYSQL/nuevo.xlsx");
          wb.write(output);
          output.close();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
