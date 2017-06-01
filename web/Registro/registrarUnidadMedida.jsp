<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String descripcion = request.getParameter("descripcion");
    boolean mensaje = controlador.insertarUnidadMedida(descripcion);
    if(mensaje){
        out.print("Registro exitoso");
    }else{
        out.print("No se pudo realizar el registro, intente más tarde");
    }
%>
