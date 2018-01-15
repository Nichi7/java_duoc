/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Concepción
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,//tomara todos los datos generados por cliente
            HttpServletResponse response)//les daremos informacion a ese cliente
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//respuesta que ve el cliente
        PrintWriter out = response.getWriter();
        try
        {//escribir en tiempo de ejecucion la pag.
            /* escribi en esa hoja en blanco los siguientes datos */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>"); 
            out.println("</head>");
            out.println("<style type='text/css'>");
            out.println("img {width:100px;heigth:100px;}");
            out.println("</style>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            if (request.getParameter("uno") != null){
            out.println("<h2> parametro: " + request.getParameter("uno").toUpperCase() +  "</h2>");
            } else
              out.println("<h2> sin parametro </h2>");   
            out.println("<p>");
            out.println("<img src='./imagenes/manzana.jpg' />");
            out.println("</p>");
            
            out.println("</body>");
            out.println("</html>");
        }finally {
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
