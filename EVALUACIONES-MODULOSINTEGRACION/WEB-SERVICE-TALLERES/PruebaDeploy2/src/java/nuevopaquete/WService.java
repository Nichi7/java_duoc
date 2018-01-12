package nuevopaquete;


import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 *
 * @author Xberto
 */
@Path("/geografia")
public class WService {
    @GET
    @Path("/regiones")
    @Produces("application/json")
    /*crea metodo que retorna un objeto de la clase Arraylist con elementos de la clase Region en formato json*/
    public ArrayList<Region> listaRegiones(){
        /*se crea arraylist con el nombre de regiones*/
        ArrayList<Region> regiones = new ArrayList();
        try{
            /*Se obtiene el objeto JSON a partir de una URL*/
            URL url = new URL("http://servelelecciones.cl/data/elecciones_presidente/filters/regiones/all.json");
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonArray objeto = reader.readArray();
            /*se recorre arraylist de regiones del api*/
            for(int i=0;i<objeto.size();i++)
                /*se agregan regiones al arraylis creado llamado regiones*/
                regiones.add(
                        /*se crea objeto region*/
                        new Region(objeto.getJsonObject(i).getInt("c"),
                                objeto.getJsonObject(i).getString("d")
                        )
                );
        }
        catch(Exception e){}
        return regiones;   
    }
    @GET
    @Path("region/{region}/ciudades")
    @Produces("application/json")
    public ArrayList<Ciudad> listaCiudades(@PathParam("region") final int region){
        ArrayList<Ciudad> ciudades = new ArrayList();
        try{
            URL url = new URL("http://servelelecciones.cl/data/elecciones_presidente/filters/comunas/byregion/"+region+".json");
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonArray objeto = reader.readArray();
            for(int i=0;i<objeto.size();i++)
                ciudades.add(
                        new Ciudad(
                                objeto.getJsonObject(i).getInt("c"),
                                objeto.getJsonObject(i).getString("d")
                        )
                );
        }
        catch(Exception e){}
        return ciudades;
    }
    
    
    
    
    
}