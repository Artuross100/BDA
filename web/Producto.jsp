<%@page import="Entidades.Producto"%>
<%@page import="Entidades.GrupoAlimentos"%>
<%@page import="Entidades.UnidadMedida"%>
<%@page import="Entidades.Enfermedad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%
    ArrayList<UnidadMedida> unidades = controlador.cargarUnidadMedida();
    ArrayList<GrupoAlimentos> grupos = controlador.cargarGrupoAlimentos();
    ArrayList<Producto> productos = controlador.cargarProductos();
%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Productos</ins></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <form class="formularioAjax" action="Registro/registrarProducto.jsp" method="post" >
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" class="form-control border-input" placeholder="Ej. 100002115" name="codigo">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control border-input" placeholder="Ej. Galletas ducales" name="nombre">
                        </div>
                        <div class="form-group">
                            <label>Peso</label>
                            <input type="number" class="form-control border-input" min="0" step="0.001" placeholder="Ej. 120" name="peso">
                            <p class="">*El peso debe registrarse en Kg</p>
                        </div>
                        <div class="form-group">
                            <label>Medida</label>
                            <input type="text" class="form-control border-input" placeholder="Ej. 530" name="medida">
                        </div>
                        <div class="form-group">
                            <label>Unidad de medida</label>
                            <select class="form-control" name="unidadMedida">
                                <%
                                    if (unidades != null && !unidades.isEmpty()) {%>
                                <option value="0">Seleccione una opción</option>
                                <%for (UnidadMedida d : unidades) {%>
                                <option value="<%=d.getId()%>"><%=d.getDescripcion()%></option>
                                <%}
                                } else {%>
                                <option value="0">No hay opciones disponibles</option>
                                <%}%>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Grupo de Alimentos</label>
                            <select class="form-control" name="grupo">
                                <%
                                    if (grupos != null && !grupos.isEmpty()) {%>
                                <option value="0">Seleccione una opción</option>
                                <%for (GrupoAlimentos d : grupos) {%>
                                <option value="<%=d.getId()%>"><%=d.getDescripcion()%></option>
                                <%}
                                } else {%>
                                <option value="0">No hay opciones disponibles</option>
                                <%}%>
                            </select>
                        </div>
                        <button type="input" class="btn btn-info btn-fill btn-wd btnEnviarAjax">REGISTRAR</button>
                    </form>
                    <p class="respuestaAjax"></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <h4><ins>Registros Disponibles</ins></h4>
                    <div class="content table-responsive table-full-width">
                        <table id="tabla" class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Presentación</th>
                                    <th>Grupo de alimentos</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    if (productos != null && !productos.isEmpty()) {
                                        for (Producto prod : productos) {%>
                                <tr>
                                    <td><%=prod.getNombre()%></td>
                                    <td><%=prod.getMedida() + " " + prod.getUnidad().getDescripcion()%></td>
                                    <td><%=prod.getGrupo().getDescripcion()%></td>
                                </tr>
                                <%}
                                } else {%>
                                <tr>
                                    <td colspan="3">No hay productos registrados</td>
                                </tr>
                                <%}
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>