package NuevoPaquete;


import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Concepción
 */
public class Webservice {
    @GET
    @Path("/listar")
    @Produces("application/json")
    public Producto getJSON(){
        Producto p = new Producto();
        p.setCodigo(10);
        p.setNombre("Zapato");
        p.setStock(30);
    }
    
}
