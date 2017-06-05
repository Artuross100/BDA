<%@page import="Entidades.Usuario"%>
<%@page import="Entidades.Pagina"%>
<%@page import="Entidades.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%ArrayList<Usuario> usuarios = controlador.listarUsuarios();%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h2><ins>Asignar Roles</ins></h2>
                </div>
            </div>
            <div id="infoResultado"></div>
            <br>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <select id="usuariosRol" name="usuarioSel" class="form-control" onchange="cargarPaginas()">
                        <%if (usuarios != null && !usuarios.isEmpty()) {%>
                        <option value="0">Seleccione un usuario</option>
                        <%for (Usuario us : usuarios) {
                        %>
                        <option value="<%=us.getId()%>"><%=us.getNombres() + " " + us.getApellidos()%></option>
                        <%}
                        } else {%>
                        <option value="0">No hay usuarios registrados</option>
                        <%}%>
                    </select>
                </div>
            </div>
            <br><hr><br>
            <div class="row">
                <div id="respuestaPaginas">
                    <div class="col-md-5 col-md-offset-1">
                        <h4><ins>Roles asignados</ins></h4>
                        <div class="content table-responsive table-full-width">
                            <table id="tabla" class="table table-striped">

                            </table>
                        </div>
                    </div>
                    <div class="col-md-5 col-md-offset-1">
                        <h4><ins>Roles sin asignar</ins></h4>
                        <div class="content table-responsive table-full-width">
                            <table id="tabla" class="table table-striped">

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="assets/js/misForm.js"></script>
        <script src="assets/js/ajaxScripts.js"></script>