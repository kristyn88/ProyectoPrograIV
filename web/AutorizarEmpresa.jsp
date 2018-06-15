<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<%@page import="org.json.JSONObject" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Autorizar Empresa</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <script src="js/loadJSON.js" type="text/javascript"></script>
    </head>
    <body onload="cargarPendientes();">
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenido administrador!</h1>
                <form id="form1" action="#" method="POST" enctype="application/x-www-form-urlencoded">
                    <table id="tablaFormulario">
                        <thead>
                        </thead>
                        <tbody id="bodyAutorizarE">
                        </tbody>
                    </table>
                    <button type="button" onclick="mandarAutorizacionEmpresa();">Autorizar</button>
                    <section>
                         <p>
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
                       
                    </p>
                    </section>
                </form>
                <section>
                    <a href="Administrador.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
