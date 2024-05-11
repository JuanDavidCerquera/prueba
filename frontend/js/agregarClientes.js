function save() {

    data = {
        "tipo_identificaion": $("#tipo_identificaion").val(),
        "identificacion": $("#identificacion").val(),
        "nombre": $("#nombre").val(),
        "apellido": $("#apellido").val(),
        "telefono": $("#telefono").val(),
        "direccion": $("#direccion").val(),
        "ciudad": $("#ciudad").val(),
        "estado": $("#estado").val(),
    }

    var jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/clientes",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (data) {
            console.log(data.data);
            alert("registro agregado con exito");
            window.location.href = "clientes.html";
        },
        error: function (error) {
            console.log("No se pudo agregar el registro" + error);
            alert("No se pudo agregar el registro")
        }
    })
}


function findById() {
    var id = localStorage.getItem("clientID");
    if (id != null) {
        $(".botonagregar").text("actualizar");
        $(".botonagregar").attr("onclick", "update()");
    }
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/clientes/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            console.log(data);
            $("#tipo_identificaion").val(data.tipo_identificaion),
                $("#identificacion").val(data.identificacion),
                $("#nombre").val(data.nombre),
                $("#apellido").val(data.apellido),
                $("#telefono").val(data.telefono),
                $("#direccion").val(data.direccion),
                $("#ciudad").val(data.ciudad),
                $("#estado").val(data.estado)
        },

    })


}

function update() {
    var id = localStorage.getItem("clientID");
    data = {
        "tipo_identificaion": $("#tipo_identificaion").val(),
        "identificacion": $("#identificacion").val(),
        "nombre": $("#nombre").val(),
        "apellido": $("#apellido").val(),
        "telefono": $("#telefono").val(),
        "direccion": $("#direccion").val(),
        "ciudad": $("#ciudad").val(),
        "estado": $("#estado").val(),
    }

    var jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/clientes/" + id,
        method: "PUT",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (data) {
            console.log(data.data);
            alert("registro actualizado con exito");
            window.location.href = "clientes.html";
        },
        error: function (error) {
            console.log("No se pudo actualizar el registro" + error);
            alert("No se pudo actualizar el registro")
        }
    })
    localStorage.setItem("clientID", null);
    window.location.href = "clientes.html";
}
function typeDocument() {
    const campo = $("#tipo_identificaion");
    $.ajax({
        url: "http://localhost:9000/prueba/v1/api/enum",
        method: "GET",
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, value) {
                campo.append($('<option></option>').attr('value', value).text(value));
            });
        }
    })
}