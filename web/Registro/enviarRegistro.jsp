<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String id = request.getParameter("donante");
    if (controlador.registrarDonacion(Long.parseLong(id))) {
        out.print("Registro exitoso");
    } else {
        out.print("No se pudo registrar");
    }
%>

