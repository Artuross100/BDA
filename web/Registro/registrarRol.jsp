<%@page import="java.util.List"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String descripcion = request.getParameter("descripcion");
    String mensaje = controlador.registrarRol(descripcion);
    out.print(mensaje);
%>

