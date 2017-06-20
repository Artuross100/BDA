<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String division = request.getParameter("division2");
    String producto = request.getParameter("producto");
    String cantidadAlmacenar = request.getParameter("cantidadAlmacenar");
    if(!controlador.almacenar(division, producto.split("-")[1], producto.split("-")[0] ,cantidadAlmacenar)){
        out.print("Registro exitoso");
    }else{
        out.print("No se pudo registrar");
    }
%>
