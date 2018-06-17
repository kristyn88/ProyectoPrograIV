<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/pdf" %>
<%@ page trimDirectiveWhitespaces="true"%>



<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Reportes</title>
    </head>
    <body>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoempleo", "root", "root");

            response.setHeader("Content-Disposition", "inline; filename=report.pdf ");
            JasperPrint print = JasperFillManager.fillReport("C:\\Users\\krist\\Downloads\\PrimeraEntrega\\SegundaEntrega\\ProyectoP4\\web\\ReportePDF\\reportOferentes.jasper",
                    new HashMap(),
                    cn);

            JasperExportManager.exportReportToPdfStream(print,
                    response.getOutputStream());

        %>
    </body>
</html>