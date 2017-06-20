<%@page import="Entidades.Donante"%>
<%@page import="Entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%ArrayList<Producto> productos = controlador.cargarProductos();%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Donación</ins></h4>
                </div>
            </div>
            <div class="row">
                <form class="formularioAjax" action="Registro/registrarDonacion.jsp" method="post" >
                    <div class="col-md-9 col-md-offset-1">
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
                            <label>Cantidad del producto donado</label>
                            <input type="number" min="1" class="form-control" name="cantidad" required/>
                        </div>
                            <div class="form-group">
                            <label>Cantidad del producto conforme</label>
                            <input type="number" min="1" class="form-control" name="conforme" required/>
                        </div>
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjax">AGREGAR PRODUCTO</button>
                    </div>
                </form>
            </div>
            <p class="respuestaAjax"></p>
            <div id="infoResultado"></div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>