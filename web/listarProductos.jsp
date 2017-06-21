<%@page import="Entidades.Bodega"%>
<%@page import="Entidades.Donante"%>
<%@page import="Entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%ArrayList<Producto> productos = controlador.cargarProductos();
    ArrayList<Bodega> bodegas = controlador.cargarBodegas();
%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Almacenar Productos</ins></h4>
                </div>
            </div>

            <form class="formularioAjax" action="Registro/almacenarProductos.jsp" method="post" >
                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                        <select class="form-control" id="bodegas2" name="bodegas2" onchange="cargarDivisionesSelect()">
                            <%if (bodegas != null && !bodegas.isEmpty()) {%>
                            <option value="0">Seleccione una bodega</option>
                            <%for (Bodega bo : bodegas) {%>
                            <option value="<%=bo.getId()%>"><%=bo.getNombre()%></option>
                            <%}
                            } else {%>
                            <option value="0">No hay registros disponibles</option>
                            <%}%>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <div id="mostrarDivisiones">
                            <select class="form-control" id="bodegas" name="bodegas">
                                <option value="0">Seleccione una division</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                    </div>
                </div>
                <div id="cargarProductosInfo">

                </div>
            </form>

            <p class="respuestaAjax"></p>
            <div id="infoResultado"></div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>
<script>
                            function listarProductosDivision() {
                                var idDivision = document.getElementById("division2").value;
                                var rutaPagina = "includes/listarProductosDivision.jsp";
                                $.post(rutaPagina, {
                                    division: idDivision
                                },
                                function(data) {
                                    $("#infoResultado").html(data);
                                });
                                console.log("Cargando las divisiones " + idDivision);
                            }
</script>
