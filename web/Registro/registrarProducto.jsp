<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String codigo = request.getParameter("codigo");
    String nombre = request.getParameter("nombre");
    String peso = request.getParameter("peso");
    String medida = request.getParameter("medida");
    String unidadMedida = request.getParameter("unidadMedida");
    String grupo = request.getParameter("grupo");
    boolean c = controlador.registrarProducto(codigo, Long.parseLong(unidadMedida), nombre, Float.parseFloat(peso), Float.parseFloat(medida), Long.parseLong(grupo));
    if (c) {
        out.print("Registro Exitoso");
    }else{
        out.print("No se pudo registrar, intente más tarde");
    }
    %>