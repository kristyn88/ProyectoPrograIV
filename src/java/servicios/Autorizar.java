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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author krist
 */
public class Autorizar extends HttpServlet {

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
            JSONObject obj = new JSONObject();//Crea un objeto JSON
            JSONArray opciones = new JSONArray();//Array del Objeto JSON
            
            
            for(int i = 0; i < modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().size(); i++){
                JSONObject opc = new JSONObject();//Objetos JSON dentro del Array Opciones
                opc.put("id", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getId_empresa());
                opc.put("nombre", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getNombre_empresa());
                opc.put("localizacion", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getLocalizacion());
                opc.put("correo", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getCorreo());
                opc.put("telefono", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getTelefono());
                opc.put("descripcion", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getDescripcion());
                opc.put("clave", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getClave());
                opc.put("fechaRegistro", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getFecha_registro());
                opc.put("estado", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getEstado());
                opc.put("usuario", modelo.DAO.ConjuntoEmpresas.obtenerInstancia().obtenerEmpresasPendientes().get(i).getUsuario());
                opciones.put(opc);
            }
            
            obj.put("opciones", opciones);
            out.println(obj);//Representacion del objeto usando un formato JSON
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
