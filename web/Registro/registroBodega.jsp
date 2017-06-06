<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String nombre = request.getParameter("nombre");
    long cant = Long.parseLong(request.getParameter("cantidad"));
    String mensaje = controlador.registrarBodega(nombre, cant);
    out.print(mensaje);
%>