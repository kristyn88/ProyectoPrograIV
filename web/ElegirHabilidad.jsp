
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <script src="js/loadJSON.js" type="text/javascript"></script>
        <title>Registrar Habilidad</title>
    </head>
    <body onload="init();">
        <div id="wrapper">
            <header></header>
            <div id="header" style="overflow: hidden;">
                <jsp:directive.include file="headerNavegacion.jsp" />
            </div>
            <div id="contents">
                <section>
                    <form id="elegirHabilidades" action="#" method="GET" >
                        <table class="tablaHabilidades">
                            <tbody>
                                <tr>
                                    <td>Categoria&nbsp;</td>
                                    <td style="width: 240px;">
                                        <select id="categoria" name="categoria" size="1" onchange="seleccionarCategoria();"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Subcategria:&nbsp;</td>
                                    <td>
                                        <select id="subcategoria" name="subcategoria" size="1" onchange="seleccionarSubCategoria();"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Nivel:&nbsp;</td>
                                    <td>
                                        <input type="number" id="nivel" name="nivel" min="1" max="10" value="1"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <button onclick="actualizarHabilidades">Agregar Habilidad</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </section>
                <section>
                    <table>
                        <thead id="encabezadoTablaHabilidades">
                            <tr>
                                Mis Habilidades
                            </tr>
                            <tr>
                                <th class="eth">Categoria</th>
                                <th class="eth">Sub-categoria</th>
                                <th class="eth">Nivel</th>
                            </tr>
                        </thead>
                    </table>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>