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
<select class="form-control" id="division2" name="division2" onchange="listarProductosDivision()">
    <%if (b != null) {
            d = b.getDivisiones();%>
            <option value="0">Seleccione una división</option>
            <%for (Division di : d) {%>
    <option value="<%=di.getIde()%>"><%=di.getId()%></option>
    <%}
    } else {%>
    <option value="0">No hay divisiones asignadas a esta bodega</option>
    <%}%>
</select>
<script src="../assets/js/misForm.js"></script>
<script src="../assets/js/jquery.dataTables.js"></script>
<script src="../assets/js/dataTables.bootstrap.js"></script>
