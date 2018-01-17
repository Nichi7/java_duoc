/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * @author Concepción
 */
@WebServlet(name = "ListarTrabajador", urlPatterns = {"/Listar.vista"})
public class ListarTrabajador extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            
            DAO dao = new DAO();
            
            List<Trabajador> trabajadores = dao.getAll();
            
            PrintWriter out = response.getWriter();
            try
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Listado de Trabajadores</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado de Trabajadores</h1>");
                
                out.println("<table>");
                    out.println("<tr>");
                    out.println("<td>Run</td>");
                    out.println("<td>Nombre Completo</td>");
                    out.println("<td>Sueldo Base</td>");
                    out.println("<td>Dcto AFP (13%)</td>");
                    out.println("<td>Dcto Salud</td>");
                    out.println("<td>Bono Producción</td>");
                    out.println("<td>Aguilnaldo</td>");
                    out.println("<td>Sueldo Liquido</td>");
                    out.println("</tr>");
                    
                for (Trabajador t: trabajadores)    {
                    
                    out.println("<tr>");
                        out.println("<td>"+t.getRun()+"</td>");
                        out.println("<td>"+t.getNombre()+" "+t.getApellidoPaterno()+" "+t.getApellidoMaterno()+"</td>");
                        out.println("<td>"+t.getSueldoBase()+"</td>");
                        out.println("<td>"+t.getAfp()+"</td>");
                        out.println("<td>"+t.getSalud()+"</td>");
                        out.println("<td>"+t.BONO_PRODUCCION+"</td>");
                        out.println("<td>"+t.getAguilnaldo()+"</td>");
                        out.println("<td>"+t.getSueldoLiquido()+"</td>");
                    out.println("</tr>");
                    
                }
                out.println("</table>");
                
                out.println("</body>");
                out.println("</html>");
            }
            finally {
                out.close();
            }
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(ListarTrabajador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarTrabajador.class.getName()).log(Level.SEVERE, null, ex);
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
