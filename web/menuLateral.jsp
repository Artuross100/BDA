<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Pagina"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
    <html> 
        <head>
        <jsp:include flush="true" page="headAdmin.jsp"></jsp:include>
        </head>
        <jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
    <%
        ArrayList<Pagina> paginas = controlador.cargarPagina();
    %>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">
                <div class="sidebar-wrapper">
                    <div class="logo" id="0" name="pruebaAjax.jsp" onclick="mostrarInformacion(0);">
                        <a href="#" class="simple-text">
                            <img src="imagenes/prueba6.png" alt="logo" height="70" width="80" title="Inicio"/>
                        </a>
                    </div>

                    <ul class="nav">
                        <%if (paginas != null && !paginas.isEmpty()) {
                                for (Pagina p : paginas) {%>
                        <li id="<%=p.getId()%>" name="<%=p.getRuta()%>" class="menuCargar" onclick="mostrarInformacion(<%=p.getId()%>);">
                            <a href="#">
                                <i class="ti-panel"></i>
                                <p><%=p.getTitulo()%></p>
                            </a>
                        </li>
                        <%}
                            }%>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <jsp:include flush="true" page="menuSuperior.jsp"></jsp:include>
                    <div id="respuesta">
                    <jsp:include flush="true" page="pruebaAjax.jsp"></jsp:include>
                    </div>
                <jsp:include flush="true" page="footerAdmin.jsp"></jsp:include>
                </div>

            </div>
        <jsp:include flush="true" page="scriptsMenu.jsp"></jsp:include>
    </body>
</html>  