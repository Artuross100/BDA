<%@page import="Entidades.Division"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Bodega"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="../util/validarSesion.jsp"></jsp:include>
<%
    long id = Long.parseLong(request.getParameter("id"));
    Bodega b = controlador.buscarBodega(id);
    ArrayList<Division> d = null;
%>
<table id="tabla" class="table table-striped">
    <thead>
    <th>Codigo Division</th>
    <th>Descripción</th>
    <th>Eliminar</th>
</thead>
<tbody>
    <%
        if (b != null) {
            d = b.getDivisiones();
            for (Division di : d) {
    %>
    <tr>
        <td><%=di.getId()%></td>
        <td><%if (di.getComentarios() == null) {
                out.print("No hay comentarios");
            } else {
                out.print(di.getComentarios());
            }%></td>
        <td><input type="checkbox" name="eliminar" /></td>
    </tr>
    <%}
        }%>
</tbody>
</table>
<script src="../assets/js/misForm.js"></script>
<script src="../assets/js/jquery.dataTables.js"></script>
<script src="../assets/js/dataTables.bootstrap.js"></script>