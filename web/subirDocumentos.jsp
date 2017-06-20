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
                    <h4><ins>Subir información de interés</ins></h4>
                </div>
            </div>

            <form class="formularioAjaxPart" action="Registro/subirDocumentos.jsp" method="post" >
                <div class="row">
                    <div class="col-md-5 col-md-offset-1 form-group">
                        <label>Nombre</label>
                        <input name="nombre" type="text" class="form-control" required />
                    </div>
                    <div class="col-md-5">
                        <div id="form-group">
                            <label>Descripción</label>
                            <input name="descripcion" type="text" class="form-control" required />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <input name="documento" type="file" class="form-control" required />  
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                        <button type="input" id="registrarDonacion" class="btn btn-info btn-fill btn-wd btnEnviarAjaxPart">REGISTRAR PRECIO</button>
                    </div>
                </div>
            </form>
            <p class="respuestaAjaxPart"></p>
        </div>
    </div>
</div>
<script src="assets/js/misForm.js"></script>
<script src="assets/js/ajaxScripts.js"></script>
