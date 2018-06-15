/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import org.json.JSONObject;

/**
 *
 * @author krist
 */

@WebServlet(name = "ServicioAutorizar", urlPatterns = {"/ServicioAutorizar"})
public class ServicioAutorizar extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

                       
            JSONObject r = new JSONObject();
            Enumeration<String> e = request.getParameterNames();
            
            while (e.hasMoreElements()) {
                String nombre = e.nextElement();
                //Se agrega a la bd
                int num = Integer.parseInt(request.getParameter("num"));
                int tipo = Integer.parseInt(request.getParameter("tipo"));
                if(tipo==1){
                    modelo.DAO.ConjuntoEmpresas.obtenerInstancia().autorizar(num, 2);
                }else{
                    modelo.DAO.ConjuntoOferentes.obtenerInstancia().autorizar(num, 2);
                }
                r.put(nombre, request.getParameter(nombre));
            }
           
            out.print(r);
            
            
        }
        try (PrintWriter out2 = new PrintWriter(response.getOutputStream())) {
            out2.println("Lo que quieras escribir");
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
