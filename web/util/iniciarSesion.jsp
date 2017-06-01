<%@page import="Entidades.Usuario"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String usuario = request.getParameter("usuario");
    String contra = request.getParameter("contra");
    Usuario u = controlador.iniciarSesion(usuario, contra);
    if (u != null) {%>
<script>
    window.location.href = "../menuLateral.jsp";
</script>

<%} else {%>
<script>
    alert("Error al intentar iniciar sesión");
    window.location.href = "../index.jsp";
</script>
<%}
%>

