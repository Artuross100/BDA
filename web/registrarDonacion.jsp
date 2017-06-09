<%@page import="Entidades.Donante"%>
<%@page import="Entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
<%ArrayList<Producto> productos = controlador.cargarProductos();
    ArrayList<Donante> donantes = controlador.listarDonantes();%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Condicion Fisica</ins></h4>
                </div>
            </div>
            <div class="row">
                <form class="formularioAjax" action="Registro/registrarDonacion.jsp" method="post" >
                    <div class="col-md-5 col-md-offset-1">
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
                            <input type="text" class="form-control" name="cantidad"/>
                        </div>
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjax">REGISTRAR</button>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Información del donante</label>
                            <select id="donantes" name="donante" class="form-control select2p">
                                <%if (donantes != null && !donantes.isEmpty()) {
                                        for (Donante d : donantes) {%>
                                <option value="<%=d.getId()%>"><%=d.getNombres() + " " + d.getApellidos()%></option>

                                <%}
                                } else {%>
                                <option value="0">No hay donantes registrados</option>
                                <%}
                                %>
                            </select>
                        </div>
                    </div>
                </form>
                <p class="respuestaAjax"></p>

            </div>
            <div id="infoResultado"></div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>