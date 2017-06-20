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
                    <div class="col-md-10 col-md-offset-1">
                        <div class="form-group">
                            <label>Información del producto</label>
                            <select id="productos" name="producto" class="form-control select2p">
                                <%if (productos != null && !productos.isEmpty()) {
                                        for (Producto prod : productos) {%>
                                <option value="<%=prod.getCodigo()%>"><%=prod.getNombre() + "-" + prod.getMedida() + " " + prod.getUnidad().getDescripcion()%></option>

                                <%}
                                } else {%>
                                <option value="0">No hay productos registrados</option>
                                <%}
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cantidad disponible</label>
                            <input type="number" class="form-control" disabled id="cantidadDisponible"/>
                        </div>
                        <div class="form-group">
                            <label>Cantidad a almacenar</label>
                            <input type="number" class="form-control" id="cantidadAlmacenar"/>
                        </div>
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjax">ALMACENAR</button>
                    </div>

                </div>
            </form>

            <p class="respuestaAjax"></p>
            <div id="infoResultado"></div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>