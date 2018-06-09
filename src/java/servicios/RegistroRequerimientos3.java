/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.ConjuntoHabilidades;
import modelo.DAO.ConjuntoPuestos;
import modelo.DAO.ConjuntoRequerimientos;
import modelo.Habilidades;
import modelo.Requerimientos;

/**
 *
 * @author krist
 */
@WebServlet(name = "RegistroRequerimientos3", urlPatterns = {"/RegistroRequerimientos3"})
public class RegistroRequerimientos3 extends HttpServlet {

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

        if (modelo.Elementos.oferente_registrando == 1) {
            int opcion, eleccion;
            try {
                opcion = Integer.parseInt(request.getParameter("opcionSR"));
            } catch (Exception ex) {
                opcion = 0;
            }

            if (opcion == 1) {
                eleccion = Integer.parseInt(request.getParameter("subcategorias"));//id de subCategoria elegida, nuevo idSubCategoria
                //En este punto se han elegido categoria y subCategoria ya existente, falta crear la habilidad
                int dominio = Integer.parseInt(request.getParameter("dominio"));
                int oferente = modelo.Elementos.id_Oferente_Requerido;
                Habilidades h = new Habilidades(oferente, eleccion, dominio);
                ConjuntoHabilidades.obtenerInstancia().agregar(h);
                modelo.Elementos.oferente_registrando = 0;
                response.sendRedirect("SesionOferente.jsp");
            } else if (opcion == 2) {
                modelo.Elementos.oferente_registrando = 1;
                response.sendRedirect("CrearHabilidad.jsp");
            } else {
                response.sendRedirect("Oferente.jsp");
                //Deberia eliminar el ultimo puesto...
            }
        } else {
            int opcion, eleccion;
            try {
                opcion = Integer.parseInt(request.getParameter("opcionSR"));
            } catch (Exception ex) {
                opcion = 0;
            }
            if (opcion == 1) {
                eleccion = Integer.parseInt(request.getParameter("subcategorias"));//id de subCategoria elegida, nuevo idSubCategoria
                //En este punto se han elegido categoria y subCategoria ya existente, falta crear el Requerimiento
                int dominio = Integer.parseInt(request.getParameter("dominio"));
                int puesto = (ConjuntoPuestos.obtenerInstancia().obtenerMayorId());
                Requerimientos r = new Requerimientos(puesto, eleccion, dominio);
                ConjuntoRequerimientos.obtenerInstancia().agregar(r);
                response.sendRedirect("ContinuarRequerimientos.jsp");
            } else if (opcion == 2) {
                response.sendRedirect("CrearRequerimiento.jsp");
            } else {
                response.sendRedirect("Empresa.jsp");
                //Deberia eliminar el ultimo puesto...
            }
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
