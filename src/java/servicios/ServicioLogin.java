/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.ConjuntoAdministradores;
import modelo.DAO.ConjuntoEmpresas;
import modelo.DAO.ConjuntoOferentes;
import modelo.Empresa;
import modelo.Oferente;

/**
 *
 * @author freddycra
 */
public class ServicioLogin extends HttpServlet {

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

        if (modelo.Elementos.tipoLogin == 1) {

            try {
                boolean usuarioValido = false;

                //Por si el request vino de loginOferente
                String correoOferente = request.getParameter("correoOferente");
                String passwordOferente = request.getParameter("claveOferente");

                if (!(correoOferente.equals("")) && passwordOferente != null) {
                    usuarioValido = ConjuntoOferentes.obtenerInstancia().verificarOferente(
                            correoOferente, passwordOferente);
                }

                if (usuarioValido) {

                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("correoUsuario", correoOferente);

                    //Busca el id por el correo
                    Oferente o = ConjuntoOferentes.obtenerInstancia().recuperarPorCorreo(correoOferente);
                    modelo.Elementos.id_Oferente_Requerido = o.getId_oferente();

                    sesion.setMaxInactiveInterval(60 * 3);
                    request.getRequestDispatcher("SesionOferente.jsp").forward(
                            request, response);
                } else {
                    request.getRequestDispatcher("Principal.jsp").forward(
                            request, response);
                }

            } finally {
                out.close();
            }

        } else if (modelo.Elementos.tipoLogin == 2) {

            try {
                boolean empresaValida = false;


                //Por so el request vino de loginEmpresa
                String correoEmpresa = request.getParameter("correoEmpresa");
                String passwordEmpresa = request.getParameter("claveEmpresa");


                if (!(correoEmpresa.equals("")) && passwordEmpresa != null) {
                    empresaValida = ConjuntoEmpresas.obtenerInstancia().verificarEmpresa(
                            correoEmpresa, passwordEmpresa);
                }


                 if (empresaValida) {

                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("correoEmpresa", correoEmpresa);

                    //Busca el id por el correo
                    Empresa e = ConjuntoEmpresas.obtenerInstancia().recuperarPorCorreo(correoEmpresa);
                    modelo.Elementos.id_Empresa_Requerida = e.getId_empresa();

                    sesion.setMaxInactiveInterval(60 * 3);
                    request.getRequestDispatcher("Empresa.jsp").forward(
                            request, response);

                } else {
                    request.getRequestDispatcher("Principal.jsp").forward(
                            request, response);
                }

            } finally {
                out.close();
            }

        } else if (modelo.Elementos.tipoLogin == 3) {

            try {
                boolean administrador = false;


                int identificacionAdministrador = Integer.parseInt(request.getParameter("identificacionAdministrador"));
                String claveAdministrador = request.getParameter("claveAdministrador");


                if ((identificacionAdministrador!=0) && claveAdministrador != null) {
                    administrador = ConjuntoAdministradores.obtenerInstancia().verificarEmpresa(
                            identificacionAdministrador, claveAdministrador);
                }

                if (administrador) {

                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("identificacionAdministrador", identificacionAdministrador);

                    modelo.Elementos.id_Administrador_Requerido = identificacionAdministrador;

                    sesion.setMaxInactiveInterval(60 * 3);
                    request.getRequestDispatcher("Administrador.jsp").forward(
                            request, response);

                }else {
                    request.getRequestDispatcher("Principal.jsp").forward(
                            request, response);
                }

            } finally {
                out.close();
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
