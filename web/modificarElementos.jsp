<%@page import="Entidades.InfoGeneral"%>
<%@page import="Negocio.DatosBanco"%>
<%@page import="Entidades.Bodega"%>
<%@page import="Entidades.Donante"%>
<%@page import="Entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<jsp:include flush="true" page="util/validarSesion.jsp"></jsp:include>
<%
%>
<div class="content">
    <div class="container-fluid">
        <div class="card">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 header">
                    <h4><ins>Modificar Elementos corporativos</ins></h4>
                </div>
            </div>
            <%InfoGeneral in = controlador.cargarInfoGeneral();%>
            <form class="formularioAjax" action="Registro/modificarElementos.jsp" method="post" >
                <div class="row">
                    <div class="col-md-5 col-md-offset-1 form-group">
                        <div id="form-group">
                            <label>Nombre</label>
                            <textarea name="nombre" type="text" class="form-control" placeholder="BDA" required><%=DatosBanco.getNombreBanco()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Dirección</label>
                            <textarea name="direccion" type="text" class="form-control" required><%=DatosBanco.getDireccion()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Teléfono</label>
                            <textarea name="telefono" type="text" class="form-control" required><%=DatosBanco.getTelefono()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Nombre representante del banco</label>
                            <textarea name="representante" type="text" class="form-control" required><%=DatosBanco.getRepresentante()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Ciudad - Departamento</label>
                            <textarea name="ciudad" type="text" class="form-control" required><%=DatosBanco.getCiudad()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Correo electrónico</label>
                            <input name="correo" type="email" class="form-control" required value="<%=DatosBanco.getCorreo()%>"/>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div id="form-group">
                            <label>Misión</label>
                            <textarea name="mision" type="text" class="form-control" required><%=in.getMision()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Visión</label>
                            <textarea name="vision" type="text" class="form-control" required><%=in.getVision()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Objetivos</label>
                            <textarea name="objetivos" type="text" class="form-control" required><%=in.getObjetivos()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Quiénes somos</label>
                            <textarea name="quienes" type="text" class="form-control" required><%=in.getQuienesSomos()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Descripción del banco</label>
                            <textarea name="descripcion" type="text" class="form-control" required><%=in.getBancoDescripcion()%></textarea>
                        </div>
                        <div id="form-group">
                            <label>Principios</label>
                            <textarea name="principios" type="text" class="form-control" required><%=in.getPrincipios()%></textarea>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjax">GUARDAR CAMBIOS</button>
                    </div>
                </div>
            </form>
            <p class="respuestaAjax"></p>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>

