<%@page import="Entidades.Pagina"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Usuario"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="../util/validarSesion.jsp"></jsp:include>
<%
    
    long id = Long.parseLong(request.getParameter("idUsuario"));
    ArrayList<Pagina> def = null;
    ArrayList<Pagina> noDef = null;

    if (id!=0) {
        def = controlador.cargarPorRol(id);
        noDef = controlador.cargarRolSinDefinir(id);
    }
%>
<div class="col-md-5 col-md-offset-1">
    <h4><ins>Roles asignados</ins></h4>
    <div class="content table-responsive table-full-width">
        <table id="tabla" class="table table-striped">
            <thead>
                <tr>
                    <th>Rol</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%if (def != null && !def.isEmpty()) {
                        for (Pagina e : def) {%>
                <tr>
                    <td><%=e.getTitulo()%></td>
                    <td><input type="checkbox" name="eliminar"/></td>
                </tr>
                <%}
                } else {%>
            <td colspan="2">No hay registros disponibles</td>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

<div class="col-md-6">
    <h4><ins>Roles sin asignar</ins></h4>
    <div class="content table-responsive table-full-width">
        <table id="tabla" class="table table-striped">
            <thead>
                <tr>
                    <th>Rol</th>
                    <th>Asignar</th>
                </tr>
            </thead>
            <tbody>
                <%if (noDef != null && !noDef.isEmpty()) {
                        for (Pagina e : noDef) {%>
                <tr>
                    <td><%=e.getTitulo()%></td>
                    <td><input type="checkbox" name="asignar"/></td>
                </tr>
                <%}
                } else {%>
            <td colspan="2">No hay registros disponibles</td>
            <%}%>
            </tbody>
        </table>
    </div>
</div>