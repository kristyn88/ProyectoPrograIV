/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.SubCategoria;
import org.json.JSONObject;

/**
 *
 * @author krist
 */
//Este servicio va a registrar categorias y subcategorias de parte del administrador...
@WebServlet(name = "RegistroCategoria", urlPatterns = {"/RegistroCategoria"})
public class RegistroCategoria extends HttpServlet {

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
                int tipo = Integer.parseInt(request.getParameter("tipo"));
                if(tipo==1){//Agrega la nueva categoria
                String categoria = request.getParameter("categoria");
                int id_categoria = modelo.DAO.ConjuntoCategorias.obtenerInstancia().obtenerMayorId()+1;
                    modelo.DAO.ConjuntoCategorias.obtenerInstancia().agregar(new Categoria(id_categoria, categoria));
                }else if (tipo==2){
                    String subCategoria = request.getParameter("subcategoria");
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    int idSUb = modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().obtenerMayorId()+1;
                    modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().agregar(new SubCategoria(idSUb, subCategoria, categoria));
                }else if(tipo==3){//Viene el id de desactivar puesto
                    //Desactivar puesto
                    int idPuesto = Integer.parseInt(request.getParameter("idPuesto"));
                    modelo.DAO.ConjuntoPuestos.obtenerInstancia().desactivarPuesto(idPuesto);
                }
                r.put(nombre, request.getParameter(nombre));
                break;
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
