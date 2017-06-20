<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String prod = request.getParameter("productos");
    String pre = request.getParameter("precio");
    if (pre != null) {
        if (!controlador.modificarPrecio(Long.parseLong(pre), prod)) {
            out.print("Registro exitoso");
        }else{
            out.print("No se puede registrar");
        }
    }else{
        out.print("El precio asignado no es valido");
    }

%>