function mostrarInformacion(identificador) {
    var divCargar = document.getElementById("respuesta");
    divCargar.innerHTML = "";
    var nombre = $("#" + identificador).attr("name");
    var imagen = document.createElement("img");
    imagen.setAttribute("src", "imagenes/cargando.gif");
    imagen.heigth = 100;
    imagen.width = 100;
    divCargar.appendChild(imagen);
    var valor = 0;
    var respuesta = $.post(nombre, {
        valor: valor
    },
    function(data, status) {
        $("#respuesta").html(data);
    });
    respuesta.then(function() {
        validarUsuario();
        $('#tabla').DataTable();
    }); 
}

function validarUsuario() {
    $(document).ready(function() {
        $("#usuario").on("keyup", function() {
            var usuario = $("#usuario").val();
            var nombre = "util/validarUsuario.jsp";
            $.post(nombre, {
                usuario: usuario
            },
            function(data, status) {
                $("#validaUsuario").html(data);
            });
        });
    });
}



