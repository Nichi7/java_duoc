/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author daniela
 */
public class InitListener implements ServletContextListener {
   
    public static String RUTA_ARCHIVO_TRABAJADORES;
   
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext sc = sce.getServletContext();
       String rutaRelativa = "/WEB-INF/data/trabajadores.dat";
       RUTA_ARCHIVO_TRABAJADORES = sc.getRealPath(rutaRelativa);
        System.out.println(RUTA_ARCHIVO_TRABAJADORES);
       
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
