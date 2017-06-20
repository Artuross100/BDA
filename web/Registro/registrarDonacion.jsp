<%@page import="Entidades.Donante"%>
<%@page import="Entidades.ProductoDonacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Donacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%
    String producto = request.getParameter("producto");
    String cantidad = request.getParameter("cantidad");
    String conforme = request.getParameter("conforme");
    boolean res = false;
    try {
        if (Long.parseLong(conforme) <= Long.parseLong(cantidad)) {
            if (Long.parseLong(producto) > 0 && Long.parseLong(cantidad) > 0) {
                res = controlador.agregarProducto(Long.parseLong(producto), Long.parseLong(cantidad), Long.parseLong(conforme));
            }
        }else{
            out.print("La cantidad del producto conforme es mayor a la cantidad ingresada.");
        }
    } catch (Exception e) {
        out.print("Ha ocurrido un error");
    }
    Donacion d = controlador.getDonacion();
    ArrayList<Donante> donantes = controlador.listarDonantes();

%>
<div id="mensajeValidacion">
    <form class="formularioAjax" method="post" action="Registro/enviarRegistro.jsp">
        <div class="row">
            <div class="col-md-8 col-md-offset-1">
                <div class="form-group">
                    <label>Información del donante</label>
                    <select id="donantes" name="donante" class="form-control select2p">
                        <%if (donantes != null && !donantes.isEmpty()) {
                                for (Donante don : donantes) {%>
                        <option value="<%=don.getId()%>"><%=don.getNombres() + " " + don.getApellidos()%></option>

                        <%}
                        } else {%>
                        <option value="0">No hay donantes registrados</option>
                        <%}
                        %>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-1">
                <%if (!res) {
                        out.print("No se pudo agregar, revisa que este producto no este registrado");
                    }
                    ArrayList<ProductoDonacion> pd = d.getProductos();
                    if (pd != null && !pd.isEmpty()) {%>
                <table id="tabla" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (ProductoDonacion pr : pd) {%>
                        <tr>
                            <td><%=pr.getProducto().getNombre() + " " + pr.getProducto().getMedida() + " " + pr.getProducto().getUnidad().getDescripcion()%></td>
                            <td><%=pr.getCantidad()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <button type="button" id="terminarProceso" class="btn btn-info btn-fill btn-wd btnEnviarAjax">TERMINAR</button>
                <%}%>
            </div>
        </div>
    </form>
</div>
<script>
    $("#terminarProceso").on("click", function() {
        var idDonante = document.getElementById("donantes").value;
        var ruta = "Registro/enviarRegistro.jsp";
        $.post(ruta, {
            donante: idDonante
        },
        function(data) {
            $("#mensajeValidacion").html(data);
        });
    });
</script>
