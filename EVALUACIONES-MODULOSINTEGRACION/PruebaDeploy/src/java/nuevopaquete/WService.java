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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Xberto
 */
@Path("/geografia")
public class WService {

    @GET
    @Path("/regiones")
    @Produces("application/json")
    public ArrayList<Region> listaRegiones() {
        ArrayList<Region> regiones = new ArrayList<>();
        try {
            URL url = new URL("http://servelelecciones.cl/data/elecciones_presidente/filters/regiones/all.json");
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonArray objeto = reader.readArray();
            for (int i = 0; i < objeto.size(); i++) {
                regiones.add(
                        new Region(objeto.getJsonObject(i).getInt("c"),
                                objeto.getJsonObject(i).getString("d")
                        )
                );
            }
        } catch (Exception e) {
        }
        return regiones;
    }

    @GET
    @Path("region/{region}/ciudades")
    @Produces("application/json")
    public ArrayList<Ciudad> listaCiudades(@PathParam("region") final int region) {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        try {
            URL url = new URL("http://servelelecciones.cl/data/elecciones_presidente/filters/comunas/byregion/" + region + ".json");
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonArray objeto = reader.readArray();
            for (int i = 0; i < objeto.size(); i++) {
                ciudades.add(
                        new Ciudad(objeto.getJsonObject(i).getInt("c"),
                                objeto.getJsonObject(i).getString("d")
                        )
                );
            }
        } catch (Exception e) {
        }
        return ciudades;

    }
}
