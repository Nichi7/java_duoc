/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.InitListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

/**
 *
 * @author daniela
 */
/*data access object, es una clase que me va a permitir ver los datos desde un archivo, base de datos o java solamente*/
public class DAO {

    private List<Trabajador> trabajadores;

    public DAO() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        File archivoTrabajadores
                = new File(InitListener.RUTA_ARCHIVO_TRABAJADORES);
        if (archivoTrabajadores.exists()) {//si el archivo existe
            /*lo cargo a la lista*/
            trabajadores = (List)IO.leerObjetodesde(InitListener.RUTA_ARCHIVO_TRABAJADORES);
            //sino lo creo vacio
        } else {
            trabajadores = new ArrayList<Trabajador>();
        }
    }

    public void create(Trabajador t) throws IOException {
        trabajadores.add(t);
        IO.escribirObjetoEn(trabajadores, InitListener.RUTA_ARCHIVO_TRABAJADORES);
    }

    public List<Trabajador>getAll() {
        return trabajadores;
    }

    //metodo si el usuario no existe devuelve null
    public Usuario exit(Usuario u) {
        //valida si los datos ingresados es correcto
        if (!u.getMail().equalsIgnoreCase("dgonzalez@agroananda.cl") && !u.getPass().equalsIgnoreCase("1234")) {
            u.addError(new Error(300, "Mails y Pass incorrectos"));
            return u;
        } else if (u.getMail().equalsIgnoreCase("dgonzalez@agroananda.cl")) {
            /*OK*/
            if (u.getPass().equalsIgnoreCase("1234")) {
                /*ok*/
                return new Usuario(u.getMail(), u.getPass(), "Daniela González");
            } else {
                /*pass incorrecta*/
                Usuario nuevoUsuario = new Usuario(u.getMail(), u.getPass(), "Daniela González");
                nuevoUsuario.addError(new Error(100, "Pass Incorrecta"));
                return nuevoUsuario;
            }
        } else {
            /*email incorrecto*/
            Usuario nuevoUsuario = new Usuario(u.getMail(), u.getPass(), "Daniela González");
            nuevoUsuario.addError(new Error(200, "E-mail Incorrecto"));
            return nuevoUsuario;
        }

    }
}
