<%@page import="Negocio.DatosBanco"%>
<div class="row" id="contacto">
    <div class="col-lg-12">
        <h2 class="page-header">Contáctenos</h2>
    </div>
    <div class="col-md-6">
        <p>Para más información:</p>
        <ul>
            <li><strong>Teléfono</strong>
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