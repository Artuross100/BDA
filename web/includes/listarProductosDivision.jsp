<%@page import="java.util.ArrayList"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String id = request.getParameter("division");
    ArrayList<String> msg = controlador.listarProductosDonacionPorDivision(id);
%>
<table class="table table-striped" id="tabla" >
    <thead>
        <tr>
            <th>C�digo del producto</th>
            <th>Descripci�n del producto</th>
            <th>Grupo de alimentos</th>
            <th>Cantidad Almacenada</th>
        </tr>
    </thead>
    <tbody>
        <%if(msg != null && !msg.isEmpty()){
            for(String s:msg){%>
            <tr>
                <td><%=s.split(",")[0]%></td>
                <td><%=s.split(",")[2]+" - "+s.split(",")[4]+" "+s.split(",")[1]%></td>
                <td><%=s.split(",")[6]%></td>
                <td><%=s.split(",")[8]%></td>
            </tr>
            <%}
        }else{%>
    <td colspan="4">No hay productos almacenados en esta divisi�n</td>
        <%}%>
    </tbody>
</table>