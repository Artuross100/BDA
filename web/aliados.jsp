<%@page import="Entidades.Aliado"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
    <div class="row" id="aliados">
        <div class="col-lg-12">
            <h2 class="page-header">Nuestros Aliados</h2>
        </div>
    <%
        ArrayList<Aliado> aliados = controlador.listarAliados();
        long con = 1;
        if (aliados != null && !aliados.isEmpty()) {
            for (Aliado a : aliados) {
                if (con % 3 == 0) {
                    con = 1;
                }%>
    <div class="col-md-4 col-sm-6">
        <a href="<%=a.getUrl()%>" target="_blank">
            <img height="250" width="350" src="<%=a.getFoto()%>" alt="<%=a.getNombre()%>">
        </a>
    </div>
    <%}
        }
    %>
</div>