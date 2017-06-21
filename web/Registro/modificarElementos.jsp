<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");
    String representante = request.getParameter("representante");
    String ciudad = request.getParameter("ciudad");
    String correo = request.getParameter("correo");
    String mision = request.getParameter("mision");
    String vision = request.getParameter("vision");
    String objetivos = request.getParameter("objetivos");
    String quienes = request.getParameter("quienes");
    String descripcion = request.getParameter("descripcion");
    String principios = request.getParameter("principios");
    boolean b = controlador.modificarElementos(nombre, direccion, telefono, representante, ciudad, correo, mision, vision, objetivos, quienes, descripcion, principios);
    if(!b){
        out.print("Modificación exitosa");
    }else{
        out.print("No se pudo realizar los cambios");
    }
%>