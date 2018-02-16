package respaldos;

import Restauracion.HiloLector;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniela
 */
public class Respaldos {

    
    public static void main(String[] args) {
        try {
            //generar el respaldo
            Process p = Runtime.getRuntime().exec("mysqldump -u root -pDaniela30/ tienda");//ingresa comando a ejecutar
            new HiloLector(p.getErrorStream()).start();
            
            InputStream is = p.getInputStream();//se obtiene la ejecucion del comando
            FileOutputStream fos = new FileOutputStream("C://Users/daniela/Desktop/TECNOLOGÍADANI/BASE-DATOS/MYSQL/BD/backup_tienda.sql");//se obtiene como saluda un archivo sql
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while(leido > 0){
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);//lee cada mi byte
            }
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
