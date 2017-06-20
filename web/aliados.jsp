<%@page import="Entidades.Aliado"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    ArrayList<Aliado> aliados = controlador.listarAliados();
%>
<div class="row" id="aliados">
    <div class="col-lg-12">
        <h2 class="page-header">Nuestros Aliados</h2>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="<%=aliados.get(0).getUrl()%>" target="_blank">
            <img height="250" width="250" src="<%=aliados.get(0).getFoto()%>" alt="<%=aliados.get(0).getNombre()%>">
        </a>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="portfolio-item.jsp">
            <img class="img-responsive img-portfolio img-hover" height="200" width="200" src="imagenes/spartan.png" alt="">
        </a>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="portfolio-item.jsp">
            <img class="img-responsive img-portfolio img-hover" src="imagenes/hp.jpg" alt="">
        </a>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="portfolio-item.jsp">
            <img class="img-responsive img-portfolio img-hover" src="imagenes/lafm.png" alt="">
        </a>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="portfolio-item.jsp">
            <img class="img-responsive img-portfolio img-hover" src="imagenes/starbucs.png" alt="">
        </a>
    </div>
    <div class="col-md-4 col-sm-6">
        <a href="portfolio-item.jsp">
            <img class="img-responsive img-portfolio img-hover" src="imagenes/pokemon.png" alt="">
        </a>
    </div>
</div>