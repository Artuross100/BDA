<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="../util/validarSesion.jsp"></jsp:include>
<%
    long id = Long.parseLong(request.getParameter("id"));
%>
<table id="tabla" class="table table-striped">
    <thead>
    <th>Codigo Bodega</th>
    <th>Nombre de la Bodega</th>
    <th>Codigo Division</th>
    <th>Descripción</th>
    <th>Eliminar</th>
</thead>
<tbody>
    <tr>
        <td><%=id%></td>
        <td><%=id%></td>
        <td><%=id%></td>
        <td><%=id%></td>
        <td><%=id%></td>
    </tr>
</tbody>
</table>
