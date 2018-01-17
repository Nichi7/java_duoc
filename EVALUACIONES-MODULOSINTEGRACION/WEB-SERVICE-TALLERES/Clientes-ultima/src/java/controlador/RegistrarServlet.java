/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO;
import modelo.Trabajador;

/**
 *
 * @author daniela
 */
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/Registrar.do"})
public class RegistrarServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            //crean variabler o atributos
            String rut, nombre, apeP, apeM;
            double sb;
            
            rut = request.getParameter("txtRut");
            nombre = request.getParameter("txtNombre");
            apeP = request.getParameter("txtApeP");
            apeM = request.getParameter("txtApeM");
            sb = Double.parseDouble(request.getParameter("txtSueldoBase"));
            //SE CREA OBJETO TRABAJADOR AL CUAL SE LE ENTREGAN LOS PARAMETROS
            Trabajador nuevo = new Trabajador(rut, nombre, apeP, apeM, sb);
            DAO dao = new DAO();
            
            dao.create(nuevo);
            
            request.getRequestDispatcher("registrarTrabajador.jsp").forward(request, response);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
