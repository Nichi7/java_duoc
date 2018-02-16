/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restauracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import respaldos.Respaldos;

/**
 *
 * @author daniela
 */
public class Restauracion {
    public static void main(String[] args) {
        try {
            //generar el respaldo
            Process p = Runtime.getRuntime().exec("mysql -u root -pDaniela30/ tienda_ok");//no utiliza el comando mysqldump
            new HiloLector(p.getErrorStream()).start();
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream("C://Users/daniela/Desktop/TECNOLOGÍADANI/BASE-DATOS/MYSQL/BD/backup_tienda.sql");//se obtiene como saluda un archivo sql
            
            byte[] buffer = new byte[1000];
            
            int leido = fis.read(buffer);
            
            while(leido > 0){
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);//lee cada mi byte
            }
            os.flush();//vaciar el buffer de salida
            os.close();
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
