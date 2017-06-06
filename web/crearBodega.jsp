
<%@page import="Entidades.Bodega"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%
    ArrayList<Bodega> bodegas = controlador.cargarBodegas();
%>
<div class="content">
    <div class="container-fluid">
        <div class="row">

            <div class="col-lg-12">
                <div class="card">

                    <div class="content">
                        <div class="row">
                            <div class="header col-md-6 col-md-offset-1">
                                <h4 class="title">Registrar Bodega</h4><br><hr>
                            </div>
                            <form class="formularioAjax" action="Registro/registroBodega.jsp" method="post">
                                <div class="col-md-6 col-md-offset-1">
                                    <div class="form-group">
                                        <label>Nombre de la Bodega</label>
                                        <input type="text" class="form-control border-input" name="nombre" placeholder="Nombre de la bodega" required/>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Cantidad de divisiones</label>
                                        <input type="number" class="form-control border-input" name="cantidad" min="1" required/>
                                    </div>
                                </div>
                                <div class="text-center col-md-6 col-md-offset-3">
                                    <button type="submit" class="btn btn-info btn-fill btn-wd btnEnviarAjax">Registrar</button>
                                </div>
                            </form>
                            <p class="respuestaAjax"></p>
                        </div>

                        <div class="col-md-10 col-md-offset-1">
                            <div class="card">
                                <div class="row">
                                    <div class="header">
                                        <h4 class="title">Eliminar Divisiones de Bodega</h4>
                                        <p class="category">En esta seccion puede eliminar divisiones de una bodega</p><br><hr>
                                    </div> 
                                </div>
                                <div class="row">
                                    <div class="col-md-7">
                                        <select class="form-control" id="bodegas" name="bodegas" onchange="cargarDivisiones()">
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
                                </div>
                                <div class="content table-responsive table-full-width" id="mostrarDivisiones">
                                    <table id="tabla" class="table table-striped">
                                        <thead>
                                        <th>Codigo Bodega</th>
                                        <th>Nombre de la Bodega</th>
                                        <th>Codigo Division</th>
                                        <th>Descripción</th>
                                        <th>Eliminar</th>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-info btn-fill btn-wd">Guardar</button>
                    </div>
                    <div class="clearfix"></div>
                    <br>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>