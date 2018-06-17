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
                        <h1><span>Opciones de Reportes</span></h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteEmpresas.jsp">
                                        <input type="submit" class="submit" value="Reportes de Empresas"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteOferentes.jsp">
                                        <input type="submit" class="submit" value="Reportes de Oferentes"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteRequerimientos.jsp">
                                        <input type="submit" class="submit" value="Reportes de Requerimientos"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteHabilidades.jsp">
                                        <input type="submit" class="submit" value="Reportes de Habilidades"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteCategorias.jsp">
                                        <input type="submit" class="submit" value="Reportes de Categorias"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteSubCategorias.jsp">
                                        <input type="submit" class="submit" value="Reportes de SubCategorias"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReporteAdministradores.jsp">
                                        <input type="submit" class="submit" value="Reportes de Administradores"/>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="ReportePDF/ReportePuestos.jsp">
                                        <input type="submit" class="submit" value="Reportes de Puestos"/>
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
