<%-- 
    Document   : CrearCategoria
    Created on : 15-abr-2018, 23:19:07
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<%@page import="org.json.JSONObject" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Crear Categoria</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/loadJSON.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <body onload="cargarPuestosEmpresa();">
        <div id="wrapper">
            <header></header>
            <div id="placa">
                <form id="form1" action="#" method="POST" enctype="application/x-www-form-urlencoded">
                    <section>
                    <table>
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <td>SubCategoria:&nbsp;</td>
                                <td>
                                    <select id="seleccionarPuesto"></select>
                                </td>
                                <td><button type="button" onclick="desactivarPuesto();">Desactivar Puesto</button></td>
                            </tr>
                        </tbody>
                    </table>
                    </section>
                    <section>
                        <table id="tablaFormulario">
                        <thead>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Salario</th>
                        <th>Tipo</th>
                        <th>Estado</th>
                        </thead>
                        <tbody id="mostrarPuestos">
                        </tbody>
                    </table>
                    </section>

                    <span id="info">
                            <%
                                JSONObject r = new JSONObject();
                                Enumeration<String> e = request.getParameterNames();
                                if (e.hasMoreElements()) {
                                    while (e.hasMoreElements()) {
                                        String nombre = e.nextElement();
                                        r.put(nombre, request.getParameter(nombre));
                                    }
                                    out.print(String.format("Normal Request: %s", r));
                                } else {
                                    out.print("(No hay información disponible)");
                                }
                            %>
                        </span>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
