function cargarPaginas() {
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
    var id = document.getElementById("bodegas").value;
    console.log(id);
    var rutaPagina = "includes/listarDivisiones.jsp";
    $.post(rutaPagina, {
        id: id
    },
    function(data) {
        $("#respuestaPaginas").html(data);
    });
}

