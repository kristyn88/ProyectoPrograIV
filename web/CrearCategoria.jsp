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
    <body onload="cargarInfoCatYSubCat();">
        <div id="wrapper">
            <header></header>
            <div id="placa">
                <form id="form1" action="#" method="POST" enctype="application/x-www-form-urlencoded">
                    <section>
                        <table>
                            <tr>
                                <td>Categoria:&nbsp;</td>
                                <td>
                                    <input id="categoria" name="categoria" type="text"/><br/>
                                </td>
                            </tr>
                        </table>
                        <button type="button" onclick="registrarCategoria();">Enviar</button>
                    </section>
                    <section>
                    <table>
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <td>SubCategoria:&nbsp;</td>
                                <td>
                                    <input id="subcategoria" name="subcategoria" type="text"/><br/>
                                </td>
                                <td>
                                    <select id="seleccionarCategoria"></select>
                                </td>
                                <td><button type="button" onclick="registrarSubCategoria();">Crear SUbCategoria</button></td>
                            </tr>
                        </tbody>
                    </table>
                    </section>
                    <section>
                        <table id="tablaFormulario">
                        <thead>
                        <th>Id</th>
                        <th>Nombre</th>
                        </thead>
                        <tbody id="mostrarCategorias">
                        </tbody>
                    </table>
                    </section>
                    
                    <section>
                        <table id="tablaFormulario">
                        <thead>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Categoria Perteneciente</th>
                        </thead>
                        <tbody id="mostrarSubCategorias">
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
