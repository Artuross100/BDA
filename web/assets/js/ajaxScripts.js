console.log("Si carga");
function cargarPaginas() {
    console.log("paginas");
    var id = document.getElementById("usuariosRol").value;
    console.log(id);
    var rutaPagina = "includes/asignarPermisos.jsp";
    $.post(rutaPagina, {
        idUsuario: id
    },
    function(data) {
        $("#respuestaPaginas").html(data);
    });
}
function cargarDivisiones() {
    console.log("divisiones");
    var id = document.getElementById("bodegas").value;
    console.log(id);
    var rutaPagina = "includes/listarDivisiones.jsp";
    $.post(rutaPagina, {
        id: id
    },
    function(data) {
        $("#mostrarDivisiones").html(data);
    });
}
function cargarDivisionesSelect() {
    console.log("divisiones");
    var id = document.getElementById("bodegas2").value;
    console.log(id);
    var rutaPagina = "includes/listarDivisionesSelect.jsp";
    $.post(rutaPagina, {
        id: id
    },
    function(data) {
        $("#mostrarDivisiones").html(data);
    });
}

