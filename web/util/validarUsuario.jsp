<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String usuario = request.getParameter("usuario");
    if (!usuario.isEmpty()) {
        boolean b = controlador.validarUsuario(usuario);
        if (b) {
            out.print("El usuario " + usuario + " ya existe");
        } else {
            out.print("El nombre de usuario " + usuario + " es valido");
        }
    }else{
        out.print("");
    }

%>
