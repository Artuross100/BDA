<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%

    String usuario= request.getParameter("usuario");
    String contra= request.getParameter("contra");
    
%>

<script>
    window.location.href="../menuLateral.jsp";
</script>
