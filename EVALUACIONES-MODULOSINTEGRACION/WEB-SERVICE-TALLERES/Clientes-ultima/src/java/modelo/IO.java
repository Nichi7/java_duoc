/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author daniela
 */
public class IO {

    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    public static void escribirObjetoEn(Object objeto, String ruta) throws IOException {
        /*si la ruta no existe la creo*/
        if (!new File(ruta).exists()) {
            String[] carpetas = ruta.split("/");
            String archivo = carpetas[carpetas.length - 1];

            if (carpetas.length != 1) {
                String rutacarpetas = "";
                for (String carpeta : carpetas) {
                    /*si la carpeta es diferente al archivo*/
                    if (!carpeta.equalsIgnoreCase(archivo)) {
                        rutacarpetas += carpeta + "/";
                    }
                }
                //creo directorios necesarios
                new File(rutacarpetas).mkdirs();
            }
            // se crea archivo con la ruta especifica
            new File(ruta).createNewFile();
        }
        fos = new FileOutputStream(ruta);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(objeto);
        
        oos.close();
        fos.close();
    }

    public static Object leerObjetodesde(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
        fis = new FileInputStream(ruta);
        ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
