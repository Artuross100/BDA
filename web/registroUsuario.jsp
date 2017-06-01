<%@page import="Entidades.TipoUsuario"%>
<%@page import="Entidades.TipoPersona"%>
<%@page import="Entidades.TipoIdentificacion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>

<%
    ArrayList<TipoIdentificacion> enf = controlador.listarTipoIdentificacion();
    ArrayList<TipoPersona> per = controlador.listarTipoPersona();
    ArrayList<TipoUsuario> tipos = controlador.listarTipoUsuario();
%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Registrar Usuario</ins></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <form class="formularioAjax" action="Registro/registrarUsuario.jsp" method="post" >
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Tipo de Documento</label>
                                    <select class="form-control" name="tipoDoc">
                                        <%if (enf != null && !enf.isEmpty()) {%>
                                        <option value="0">Seleccione una opción</option>
                                        <%for (TipoIdentificacion e : enf) {%>
                                        <option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
                                        <%}
                                        } else {%>
                                        <option value="0">No hay registros disponibles</option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Número de documento</label>
                                    <input type="text" name="numDoc" class="form-control" placeholder="Número de documento" />
                                </div>
                                <div class="form-group">
                                    <label>Tipo de Usuario</label>
                                    <select class="form-control" name="tipoUsuario">
                                        <%if (tipos != null && !tipos.isEmpty()) {%>
                                        <option value="0">Seleccione una opción</option>
                                        <%for (TipoUsuario e : tipos) {%>
                                        <option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
                                        <%}
                                        } else {%>
                                        <option value="0">No hay registros disponibles</option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Tipo de persona</label>
                                    <select class="form-control" name="tipoPersona">
                                        <%if (per != null && !per.isEmpty()) {%>
                                        <option value="0">Seleccione una opción</option>
                                        <%for (TipoPersona e : per) {%>
                                        <option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
                                        <%}
                                        } else {%>
                                        <option value="0">No hay registros disponibles</option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" name="usuario" class="form-control" placeholder="Usuario" id="usuario" />
                                    <p id="validaUsuario"></p>
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" name="contra" class="form-control" placeholder="Contraseña" id="contra" />
                                    <p id="validaContra"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Nombres</label>
                                    <input type="text" name="nombres" class="form-control" placeholder="Nombres"/>
                                </div>
                                <div class="form-group">
                                    <label>Apellidos</label>
                                    <input type="text" name="apellidos" class="form-control" placeholder="Apellidos" />
                                </div>
                                <div class="form-group">
                                    <label>Dirección</label>
                                    <input type="text" name="direccion" class="form-control" placeholder="Dirección" />
                                </div>
                                <div class="form-group">
                                    <label>Teléfono</label>
                                    <input type="text" name="telefono" class="form-control" placeholder="Teléfono" />
                                </div>
                                <div class="form-group">
                                    <label></label>
                                </div>
                                <div class="form-group">
                                    <label>Fecha de nacimiento</label>
                                    <input type="date" name="fechaNacimiento" class="form-control" />
                                </div>
                            </div>
                            <button type="input" class="btn btn-info btn-fill btn-wd btnEnviarAjax">REGISTRAR</button>
                        </div>
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
                                    <th>Usuarios registrados</th>
                                </tr>
                            </thead>
                            <tbody>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script>
    

</script>