/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO;
import modelo.Usuario;
import modelo.Error;

/**
 *
 * @author daniela
 */
@WebServlet(name = "ValidarServlet", urlPatterns = {"/Validar.do"})
public class ValidarServlet extends HttpServlet {

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
       //crear un objeto tiPo DAO
       DAO dao = new DAO();
       String mail, pass;
       //pasar los parametros
       mail= request.getParameter("txtMail");
       pass = request.getParameter("txtPass");
       Usuario u = new Usuario(mail, pass);
       Usuario u2 = dao.exit(u);
       //si hay errores en el usuario
       HttpSession session = request.getSession();//obtengo la sesion
       if(u2.errorExiste()){
           /*enviar a error.vista (Lista de errores)*/
           List<Error> errores = u2.getErrores();
           //tengo la lista de errores y debo enviarla atraves de la sesion
           
           session.setAttribute("errores", errores);
           request.getRequestDispatcher("Error.vista").forward(request, response);
       }else{
           /*menu*/
            session.setAttribute("usuario", u2);
           request.getRequestDispatcher("Menu.vista").forward(request, response);
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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
