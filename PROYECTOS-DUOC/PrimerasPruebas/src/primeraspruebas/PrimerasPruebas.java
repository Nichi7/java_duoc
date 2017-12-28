/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeraspruebas;

import java.util.Scanner;
/**
 *
 * @author daniela
 */
public class PrimerasPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int valor;
 
        Scanner lector = new Scanner(System.in);
        // Aqui las instrucciones de inicio y control del programa
        System.out.print("Ingrese Valor: ");
        valor = lector.nextInt();
        switch(valor){
            case 1:
                System.out.println("Ingreso valor 1");
                break;
            case 2:
                System.out.println("Ingreso Valor 2");
                break;
            case 3:
                System.out.println("Ingreso Valor 3");
                break;
            default: 
                    System.out.println("Valor desconocido");
        }
        System.out.println("FIN DEL PROGRAMA");
        
    }/*fin del método main*/
}/*fin de la clase*/
