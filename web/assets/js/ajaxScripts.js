console.log("Hola");
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


