<%@page import="Entidades.Bodega"%>
<%@page import="Entidades.Donante"%>
<%@page import="Entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%ArrayList<Producto> productos = controlador.cargarProductos();
%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Precio</ins></h4>
                </div>
            </div>

            <form class="formularioAjax" action="Registro/asignarPrecio.jsp" method="post" >
                <div class="row">
                    <div class="col-md-5 col-md-offset-1 form-group">
                        <label>Productos registrados</label>
                        <select class="form-control" id="bodegas2" name="productos" onchange="">
                            <%if (productos != null && !productos.isEmpty()) {%>
                            <option value="0">Seleccione un producto</option>
                            <%for (Producto prod : productos) {%>
                            <option value="<%=prod.getCodigo()%>"><%=prod.getNombre() + "-" + prod.getMedida() + " " + prod.getUnidad().getDescripcion()+" Precio:"+prod.getPrecio()%></option>
                            <%}
                            } else {%>
                            <option value="0">No hay registros disponibles</option>
                            <%}%>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <div id="form-group">
                            <label>Precio del producto</label>
                            <input name="precio" type="number" class="form-control" required />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjax">REGISTRAR PRECIO</button>
                    </div>
                </div>
            </form>
            <p class="respuestaAjax"></p>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>
