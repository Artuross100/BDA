<%@page import="Entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String tipoDoc = request.getParameter("tipoDoc");
    String numDoc = request.getParameter("numDoc");
    String tipoUsuario = request.getParameter("tipoUsuario");
    String tipoPersona = request.getParameter("tipoPersona");
    String usuario = request.getParameter("usuario");
    String contra = request.getParameter("contra");
    String nombres = request.getParameter("nombres");
    String apellidos = request.getParameter("apellidos");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");
    String fechaNacimiento = request.getParameter("fechaNacimiento");
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaNac = null;
    String mensaje="Problemas en el servidor, comuníquese con el administrador";
    if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
        fechaNac = formatoDelTexto.parse(fechaNacimiento);
    }
    mensaje= controlador.registrarUsuario(tipoDoc, tipoPersona,
            tipoUsuario, usuario, contra, nombres,
            apellidos, direccion, telefono,
            fechaNac, numDoc);
    ArrayList<Usuario> usuarios = controlador.listarUsuarios();
%>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <p><%=mensaje%></p>
        <h4><ins>Registros Disponibles</ins></h4>
        <div class="content table-responsive table-full-width">
            <table id="tabla" class="table table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Tipo de Usuario</th>
                        <th>Dirección</th>
                        <th>Telefono</th>
                    </tr>
                </thead>
                <tbody>
                    <%if (usuarios != null && !usuarios.isEmpty()) {
                            for (Usuario u : usuarios) {%>
                    <tr>
                        <td><%=u.getNombres() + " " + u.getApellidos()%></td>
                        <td><%=u.getTipoUsuario().getDescripcion()%></td>
                        <td><%=u.getDireccion()%></td>
                        <td><%=u.getTelefonos()%></td>
                    </tr>
                    <%}
                        }%>

                </tbody>
            </table>
        </div>
    </div>
</div>
