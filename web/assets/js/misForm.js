function FormularioAjaxPart() {
    var btnEnviar = $(".btnEnviarAjaxPart");
    for (var i = 0; i < btnEnviar.length; i++) {
        btnEnviar[i].addEventListener('click', enviarFormAjaxPart.bind(null, i));
    }
}
function FormularioAjax() {
    var btnEnviar = $(".btnEnviarAjax");
    for (var i = 0; i < btnEnviar.length; i++) {
        btnEnviar[i].addEventListener('click', enviarFormularioAjax.bind(null, i));
    }
}
function formulCkEditorAjax() {
    var btnEnviar = $(".btnEnviarAjax1");
    for (var i = 0; i < btnEnviar.length; i++) {
        btnEnviar[i].addEventListener('click', enviarFormulCkEditorAjax.bind(null, i));
    }
}
function FormularioEnviarDoc() {
    var btnEnviar = $(".btnEnviarDocumentos");
    for (var i = 0; i < btnEnviar.length; i++) {
        btnEnviar[i].addEventListener('click', enviarFormAjaxDoc.bind(null, i));
    }
}

function enviarFormAjaxDoc(index) {
    $(".formularioDoc").bind("submit", function() {
        var btnEnviar = $('.btnEnviarDocumentos');
        var formData = new FormData($('.formularioDoc')[index]);
        $.ajax({
            type: $(this).attr("method"),
            url: $(this).attr("action"),
            //data: $(this).serialize(),
            data: formData,
            contentType: false,
            processData: false,
            beforeSend: function() {
                btnEnviar.attr("disabled", "disabled");
                $(".respuestaDoc").html("<img src='http://softwaredelnorte.com:8080/imagenesHeartsTics/cargando.gif' class='img-gif'>");
            },
            complete: function(data) {
                btnEnviar.removeAttr("disabled");
            },
            success: function(data) {
                $('.formularioDoc')[index].reset();
                $(".respuestaDoc").html(data);
            },
            error: function(data) {
                alert("Problemas al tratar de enviar el formulario");
            }
        });
        return false;
    });
}

function enviarFormAjaxPart(index) {
    $(".formularioAjaxPart").bind("submit", function() {
        var btnEnviar = $('.btnEnviarAjaxPart');
        var formData = new FormData($('.formularioAjaxPart')[index]);
        $.ajax({
            type: $(this).attr("method"),
            url: $(this).attr("action"),
            //data: $(this).serialize(),
            data: formData,
            contentType: false,
            processData: false,
            beforeSend: function() {
                btnEnviar.attr("disabled", "disabled");
                $(".respuestaAjaxPart").html("<img src='http://softwaredelnorte.com:8080/imagenesHeartsTics/cargando.gif' class='img-gif'>");
            },
            complete: function(data) {
                btnEnviar.removeAttr("disabled");
            },
            success: function(data) {
                $('.formularioAjaxPart')[index].reset();
                $(".respuestaAjaxPart").html(data);
            },
            error: function(data) {
                alert("Problemas al tratar de enviar el formulario");
            }
        });
        return false;
    });
}
function enviarFormularioAjax(index) {
    $(".formularioAjax").bind("submit", function() {
        var btnEnviar = $(".btnEnviarAjax");
        $.ajax({
            type: $(this).attr("method"),
            url: $(this).attr("action"),
            data: $(this).serialize(),
            beforeSend: function() {
                btnEnviar.attr("disabled", "disabled");
            },
            complete: function(data) {
                btnEnviar.removeAttr("disabled");
            },
            success: function(data) {
                $(".formularioAjax")[index].reset();
                $(".respuestaAjax").html(data);
            },
            error: function(data) {
                alert("Problemas al tratar de enviar el formulario");
            }
        });
        return false;
    });
}
function enviarFormulCkEditorAjax(index) {
    $(".formularioAjax1").bind("submit", function() {
        var btnEnviar = $(".btnEnviarAjax1");
        var inputForm = $(".inputFormCk");
        var inputs = "";
        for (var i = 0; i < inputForm.length; i++) {
            inputs += "/@" + inputForm[i].value;
        }
        var instance = CKEDITOR.instances.textContent;
        if (instance) {
            instance.updateElement();
            var textCk = instance.getData();
        }
        $.ajax({
            type: $(this).attr("method"),
            url: $(this).attr("action"),
            data: {inputs: inputs, textCk: textCk},
            beforeSend: function() {
                btnEnviar.attr("disabled", "disabled");
            },
            complete: function(data) {
                btnEnviar.removeAttr("disabled");
            },
            success: function(data) {
                $(".formularioAjax1")[index].reset();
                $(".respuestaAjax1").html(data);
            },
            error: function(data) {
                alert("Problemas al tratar de enviar el formulario");
            }
        });
        return false;
    });
}
$(document).ready(function() {
    FormularioAjax();
    FormularioAjaxPart();
    formulCkEditorAjax();
});


