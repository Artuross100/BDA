<%@page import="Entidades.Usuario"%>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
    if (u == null) {%>
<script>
    alert("Por favor inicie sesión");
    window.location.href = "index.jsp";
</script>
<%}
%>
