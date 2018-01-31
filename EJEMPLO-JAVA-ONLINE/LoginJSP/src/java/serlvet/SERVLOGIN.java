/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.Acceso;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author daniela
 */
public class SERVLOGIN extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombre;
            String contra;
            int nivel= 0;
            
            Acceso acc = new Acceso(); // creo objeto para llamar a los métodos de la clase Acceso
            
            RequestDispatcher rd = null; //hacia donde se encaminaran las respuestas de este servlet
            
            if(request.getParameter("btniniciar")!=null){//si se envio, recibo los parametros del formulario
                nombre = request.getParameter("txtusuario");
                contra =request.getParameter("txtcontra");
                nivel = acc.validar(nombre, contra);
                
                request.setAttribute("nivel", nivel);
                request.setAttribute("nombre", nombre);
                rd = request.getRequestDispatcher("index.jsp");
                
                
            }
           
            rd.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
