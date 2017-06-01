<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String tipoDoc=request.getParameter("tipoDoc");
    String numDoc=request.getParameter("numDoc");
    String tipoUsuario=request.getParameter("tipoUsuario");
    String tipoPersona=request.getParameter("tipoPersona");
    String usuario=request.getParameter("usuario");
    String contra=request.getParameter("contra");
    String nombres=request.getParameter("nombres");
    String apellidos=request.getParameter("apellidos");
    String direccion=request.getParameter("direccion");
    String telefono=request.getParameter("telefono");
    String fechaNacimiento=request.getParameter("fechaNacimiento");
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaNac = null;
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            fechaNac = formatoDelTexto.parse(fechaNacimiento);
        }
    out.print(controlador.registrarUsuario(tipoDoc, tipoPersona, 
            tipoUsuario, usuario, contra, nombres, 
            apellidos, direccion, telefono, 
            fechaNac, numDoc));
%>
