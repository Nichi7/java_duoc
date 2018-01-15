/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Concepción
 */
public class ibiza {

    public void getindicador(Producto p) {

        try {
            System.out.println("Obteniendo variaciones de : " + p.getMoneda());

            URL url = new URL("http://mindicador.cl/api/" + p.getMoneda());
            System.out.println("Consumiendo JSON...");
            InputStream ent = url.openStream();
            JsonReader read = Json.createReader(ent);
            JsonObject obj = read.readObject();
            //queremos un solo valor
            float valor = Float.parseFloat(obj.getJsonArray("serie").getJsonObject(0).get("valor").toString());
            System.out.println("valor" + valor);
            p.setValorMoneda(valor);
            System.out.println(""+p.getValorMoneda());
        } catch (Exception e) {
            System.out.println("" + e.getCause());
        }
        
    }
}
