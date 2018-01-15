/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial;

import Control.Controldb;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Concepción
 */
@WebServlet(name = "AgregarUsuario", urlPatterns = {"/AgregarUsuario"})
public class AgregarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            //conectase, agregar y cerrar conexion
            try //genera un objeto de la clase control
            {
                Controldb oControldb = new Controldb();
                //genera un objeto de la clase usuario
                Usuario oUsuario = new Usuario(
                //se pasan los paarametros al objeto usuario
                request.getParameter("txtusuario").toString(),
                request.getParameter("txtclave").toString(),
                request.getParameter("txtnombre").toString(),
                request.getParameter("txtcmdtipo").toString().charAt(0)
                );
                if (oControldb.conectar("registro", "root", "Daniela30/")) 
                {
                    if (oControldb.registroUsuarios(oUsuario)) 
                    {
                        out.println("<h3>Operación realizada correctamente</h3>");
                    } 
                    else 
                    {
                        out.println("<h3>Error: " + oControldb.getLastError() + "</h3>");
                    }
                    if (!oControldb.desconectar()) 
                    {
                        out.println("<h3>Error: " + oControldb.getLastError() + "</h3>");
                    }
                } 
                else 
                {    
                    out.println("<h3>Error: " + oControldb.getLastError() + "</h3>");
                }
             out.println("</body>");
             out.println("</html>");
             }
             finally
            {
                out.close();
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
