<%@page import="Negocio.DatosBanco"%>
<div class="row" id="contacto">
    <div class="col-lg-12">
        <h2 class="page-header">Cont�ctenos</h2>
    </div>
    <div class="col-md-6">
        <p>Para m�s informaci�n:</p>
        <ul>
            <li><strong>Tel�fono</strong>
            </li>
            <li><%=DatosBanco.getTelefono()%></li>
            <li><%=DatosBanco.getDireccion()%></li>
            <li><%=DatosBanco.getCiudad()%></li>
            <li><%=DatosBanco.getRepresentante()%></li>
        </ul>
    </div>
    <div class="col-md-6">
        <img class="img-responsive" height="400" width="250" src="imagenes/contacto.png" alt="">
    </div>
</div>