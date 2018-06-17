<%@page import="modelo.Puesto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Principal</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <script src="js/loadJSON.js" type="text/javascript"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body onload="cargarCarrusel();">
        <header></header>
        <div id="wrapper">
            <form id="form1" action="#" method="POST" enctype="application/x-www-form-urlencoded">
                <header>
                </header>
                <div id="header" style="overflow: hidden;">
                    <jsp:directive.include file="headerNavegacion.jsp" />
                </div>
                <div id="contents">
                    <br/>
                    <br/>
                    <h1 class="titulo">Bienvenidos al Banco de Empleo</h1>
                </div>

                <br/><br/>
                <div class="container">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                            <li data-target="#myCarousel" data-slide-to="4"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">

                            <div class="item active">
                                <img src="work.jpg" alt="Primero" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3 id="nombreT1"></h3>
                                    <h2 id="descripcionT1"></h2>
                                    <p id="salarioT1"></p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="work.jpg" alt="Segundo" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3 id="nombreT2"></h3>
                                    <h2 id="descripcionT2"></h2>
                                    <p id="salarioT2"></p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="work.jpg" alt="Tercero" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3 id="nombreT3"></h3>
                                    <h2 id="descripcionT3"></h2>
                                    <p id="salarioT3"></p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="work.jpg" alt="Cuarto" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3 id="nombreT4"></h3>
                                    <h2 id="descripcionT4"></h2>
                                    <p id="salarioT4"></p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="work.jpg" alt="Quinto" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3 id="nombreT5">Trabajo 5</h3>
                                    <h2 id="descripcionT5"></h2>
                                    <p id="salarioT5">Salario: 1 000 000$</p>
                                </div>
                            </div>

                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <br/><br/><br/>
                <center>
                <div id="busqueda">
                    <div class="box">
                        <div class="container-4">
                            <input type="search" id="search" placeholder="Buscar puestos...." />
                            <button class="icon"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </div>
                </center>
                    <table>
                        <thead>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                <br/><br/>
            </form>
        </div>
        <footer style="background-color: gray;"></footer>
    </body>
</html>
