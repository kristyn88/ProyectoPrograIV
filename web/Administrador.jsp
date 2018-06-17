<%-- 
    Document   : Empresa
    Created on : 14-abr-2018, 0:53:45
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Empresa (Pagina Principal)</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="header" style="overflow: hidden;">
                <jsp:directive.include file="headerNavegacion.jsp" />
            </div>
            <div id="contents">
                <br/><br/>
                <section class="section">
                    <center>
                        <h1><span>Bienvenido Administrador!</span></h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <a href="AutorizarEmpresa.jsp"><button class="submit">Autorizar Empresas</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="AutorizarOferente.jsp"><button class="submit">Autorizar Oferentes</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="CrearCategoria.jsp"><button class="submit">Crear Áreas</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="Reportes.jsp">
                                        <input type="submit" class="submit" value="Generar Reportes"/>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </center>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
