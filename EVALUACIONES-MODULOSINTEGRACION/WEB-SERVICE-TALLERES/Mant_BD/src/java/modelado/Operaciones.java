/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.util.List;

/**
 *
 * @author daniela
 */
/*es una clase, solo van definiciones de metodos, no cuerpo de metodos,
interface las heredare a todas las clases DAO, estandarizar los objetos DAO*/
public interface Operaciones {
    public String insertar(Object obj);
    public String eliminar(Object obj);
    public String modificar(Object obj);
    public List<?> consultar();
    public List<?> filtrar(String campo, String criterio);
}
