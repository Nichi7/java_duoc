/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letramayuscula;

/**
 *
 * @author daniela
 */
public class LetraMayuscula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "jUan peRez perez daniela gonzalez";
        System.out.println(convertirMayuscula(nombre));
        
    }

    //crear método
    public static String convertirMayuscula(String p) {
        //declarando variables e iniciaizandolas
        String stg = "";
        char letrauno = ' ';
        char c = ' ';
        int aux = 0;
        //recorrer string
        for (int i = 0; i < p.length(); i++) {
            letrauno = p.charAt(0); //letra uno sera igual a la primera letra del string
            c = p.charAt(i); //varible que guarda el string completo
            if (letrauno == ' ') {
                stg = "UN NOMBRE NO PUEDE EMPEZAR POR ESPACIO";
                
            } else if (!Character.isLetter(letrauno)) {
                stg = "Uno nombre no puede empezar por ningun carácter que no sea letra del alfabeto español";
            }
            if(i==0){
                c=Character.toUpperCase(c);
            }   
            if(i >=1){
                c=Character.toLowerCase(c);
            }
            if(c == ' '){
                aux =(i+1);//variable aux guarda la posicion siguiente
            }
            if(aux ==i){
                c=Character.toUpperCase(c);
            }
            stg+=c;
            }

        

        return stg;
    }
}

