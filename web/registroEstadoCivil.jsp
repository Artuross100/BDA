<%@page import="Entidades.EstadoCivil"%>
<%@page import="Entidades.Enfermedad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
    <jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%ArrayList<EstadoCivil> enf = controlador.listarEstadoCivil();%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Estado Civil</ins></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <form class="formularioAjax" action="Registro/registrarEstadoCivil.jsp" method="post" >
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" class="form-control border-input" placeholder="Estado Civil" name="descripcion">
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
                                    <th>Estado Civil</th>
                                    <th>Fecha de registro</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%if (enf != null && !enf.isEmpty()) {
                                        for (EstadoCivil e : enf) {%>
                                <tr>
                                    <td><%=e.getDescripcion()%></td>
                                    <td><%=e.getFecha()%></td>
                                </tr>
                                <%}
                                    }%>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>