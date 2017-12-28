/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinacional;

/**
 *
 * @author Xberto
 */
public interface ProductoDescontable {
    public double porcentajeDescuento = 0.13;
    
    public double calcularDescuento(String horario);
}
