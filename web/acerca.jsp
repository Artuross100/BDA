<%@page import="Entidades.InfoGeneral"%>
<jsp:useBean id="controlador" scope="session" class="Controller.Controlador"></jsp:useBean>
<%InfoGeneral inf = controlador.cargarInfoGeneral();%>
<div class="row" id="about">
    <div class="col-lg-12">
        <h1 class="page-header">
            Nosotros
        </h1>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-check"></i>Misión</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getMision()%></p>            
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-search"></i>Visión</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getVision()%></p>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-compass"></i>Objetivos</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getObjetivos()%></p>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-question-circle"></i>Quienes somos</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getQuienesSomos()%></p>            
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-folder"></i>Descripción del banco</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getBancoDescripcion()%></p>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4><i class="fa fa-fw fa-users"></i>Principios y valores</h4>
            </div>
            <div class="panel-body">
                <p class="text-justify"><%=inf.getPrincipios()%></p>
            </div>
        </div>
    </div>
</div>