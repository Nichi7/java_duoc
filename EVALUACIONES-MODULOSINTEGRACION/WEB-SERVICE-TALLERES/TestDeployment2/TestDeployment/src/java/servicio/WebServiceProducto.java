/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import negocio.Cliente;
import negocio.Producto;

/**
 *
 * @author Concepción
 */
//Marca la clase para que sea un servicio web
@Path("/json/producto")
public class WebServiceProducto {
    /*crea metodo que retorna un objeto de la clase negocio(producto) en formato json*/
    @GET
    @Path("/get")
    @Produces("application/json")
    /*se obtiene un objeto JSON a partir de datos ingresados manualmente*/
    public Producto getProductoJSON(){
        Producto producto = new Producto();//crea objeto producto
        producto.setNombre("iPhone");
        producto.setCodigo(20000);
        producto.setStock(30);
        return producto; 
    }  
    @GET
    @Path("/get2")
    @Produces("application/json")
    public Cliente getClienteJSON(){
        Cliente cliente = new Cliente();//crea objeto cliente
        cliente.setRut("18.568.707-k");
        cliente.setNombre("Juan Perez");
        cliente.setCelular(957136339);
        
        return cliente; 
    }  
}
