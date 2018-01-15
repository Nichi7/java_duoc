/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daniela
 */
/*data access object, es una clase que me va a permitir ver los datos desde un archivo, base de datos o java solamente*/
public class DAO {
    //metodo si el usuario no existe devuelve null
    public Usuario exit(Usuario u) {
        //valida si los datos ingresados es correcto
        if(!u.getMail().equalsIgnoreCase("dgonzalez@agroananda.cl")&& !u.getPass().equalsIgnoreCase("1234"))
        {
        u.addError(new Error(300, "Mails y Pass incorrectos"));
        return u;
        }else if(u.getMail().equalsIgnoreCase("dgonzalez@agroananda.cl")){
            /*OK*/
            if(u.getPass().equalsIgnoreCase("1234")){
                /*ok*/
                return new Usuario(u.getMail(), u.getPass(), "Daniela González");
            }else {
            /*pass incorrecta*/
            Usuario nuevoUsuario = new Usuario(u.getMail(), u.getPass(), "Daniela González");
            nuevoUsuario.addError(new Error(100, "Pass Incorrecta"));
            return nuevoUsuario;
            }
        }else{
           /*email incorrecto*/ 
           Usuario nuevoUsuario = new Usuario(u.getMail(), u.getPass(), "Daniela González");
            nuevoUsuario.addError(new Error(200, "E-mail Incorrecto"));
            return nuevoUsuario;
        }
        
    }
}
