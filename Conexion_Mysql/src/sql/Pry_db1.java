/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author daniela
 */
public class Pry_db1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //invocar los metodos necesario de las otra clases controdb y probar su ejecucion
        //se crea objeto oControldb
        Controldb oControldb = new Controldb();
        Usuario oUsuario = new Usuario("lena", "345t", "Maria del Pilar", 'u');

        if (oControldb.conectar("registro", "root", "Daniela30/")) {
            System.out.println("Conectado");
            if (oControldb.consultaUsuarios()) {
                System.out.println("Consulta exitosa");
                if (oControldb.registroUsuarios(oUsuario)) {
                    System.out.println("desconectado");
                } else {
                    System.out.println("Error: " + oControldb.getLastError());
                }
            } else {
                System.out.println("Error: " + oControldb.getLastError());
            }
        } else {
            System.out.println("Error: " + oControldb.getLastError());
        }

    }

}
