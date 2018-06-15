<%-- 
    Document   : SesionOferente
    Created on : 16-abr-2018, 20:38:36
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenido Oferente</h1>
                <section class="section">
                    <center>
                        <h1><span>Bienvenido Oferente!</span></h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <a href="ElegirHabilidad.jsp"><button class="submit">Registrar Habilidad</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="buscar.jsp"><button class="submit">Buscar Puestos</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="Curriculum.jsp"><button class="submit">Subir Curriculo</button></a>
                                </td>
                            </tr>
                        </table>
                    </center>
                </section>
            </div>
            <p>
                Su sesion es:
                <%
                    out.print(modelo.Elementos.id_Oferente_Requerido);
                %>
            </p>
            <footer></footer>
        </div>
    </body>
</html>
